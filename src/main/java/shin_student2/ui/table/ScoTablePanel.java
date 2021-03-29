package shin_student2.ui.table;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import shin_student2.dto.Student;
import shin_student2.service.ScoreService;
import shin_student2.service.StudentService;
import shin_student2.ui.scoManagFrame;
import shin_student2.ui.exception.NotSelectedException;

public class ScoTablePanel extends SuperTable<Student> {
	private StudentService service;
	private ScoreService scoService = ScoreService.getInstance();

	@Override
	public Object[] getColumnNames() {
		ArrayList<String> list = new ArrayList<>();
		list.add("학번");
		list.add("학과");
		list.add("이름");
		if (super.list != null)
			for (int i = 0; i < super.list.get(0).getScores().size(); i++) {
				list.add(super.list.get(0).getScores().get(i).getSubject().getSubName());
			}
		list.add("총점");
		list.add("평균");
		list.add("평어");
		list.add("평점");
		Object[] arr = list.toArray();
		System.out.println(Arrays.toString(arr));
		return arr;
	}

	@Override
	protected void setTebleModelMode() {
		try {
			setTableCellAlign(SwingConstants.CENTER, 0, 1);
			setTableCellAlign(SwingConstants.RIGHT, 2, 3, 4, 5, 6, 7, 9);

			// 컬럼별 간격 조정
//				setTableCellWidth(100,100,80,80,80,80,100); 10개

			// 조건별 행 색깔 변경
			setTableCellcondition(9);
		} catch (ArrayIndexOutOfBoundsException e) {

		}

	}

	@Override
	public Object[] toArray(Student s) {
		ArrayList<Object> list = new ArrayList<>();
		list.add(s.getNo());
		list.add(s.getDeptno().getDeptname());
		list.add(s.getName());
		for (int i = 0; i < s.getScores().size(); i++) {
			if (s.getScores().get(i).getScoer() == -1) {
				list.add("점수없음");
			} else {
				list.add(s.getScores().get(i).getScoer());
			}
		}
		list.add(s.getTotal() == -1 ? "점수없음" : s.getTotal());
		list.add(s.getAvg());
		list.add(s.getRank().getRank());
		list.add(s.getRank().getRanksco());

		return list.toArray();
	}

	@Override
	protected void initList(String where) {
		list = service.selectByWhere(where);
		if (list != null) {
			for (Student s : list) {
				s.setScores(scoService.selectScores(s));
				s.setRank(service.rankSelect(s));
			}
		}

	}

	public void setService(StudentService service) {
		this.service = service;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource() == update) {
				Student student = getItem();
				scoManagFrame frame = new scoManagFrame();
				frame.setVisible(true);
				frame.getBtnUp().setText("저장");
				frame.setvalue(student);
				frame.upTable(this);
			}
			if (e.getSource() == delete) {
				Student student = getItem();
				service.removeStudent(student);
				loadData("");
			}
		} catch (NotSelectedException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
	}

	@Override
	public Student getItem() {
		int idx = table.getSelectedRow();
		if (idx == -1) {
			throw new NotSelectedException();
		}
		int stdno = (int) table.getValueAt(idx, 0);
		return list.get(list.indexOf(new Student(stdno)));
	}

	

	@Override
	public MouseAdapter tableMouseClicked() {
		// TODO Auto-generated method stub
		return null;
	}
}
