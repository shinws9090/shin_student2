package shin_student2.ui.table;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import shin_student2.dto.Student;
import shin_student2.service.StudentService;
import shin_student2.ui.scoManagFrame;
import shin_student2.ui.stdManagFrame;
import shin_student2.ui.exception.NotSelectedException;

public class ScoTablePanel extends SuperTable {
	private StudentService service;

	@Override
	public String[] getColumnNames() {
		// TODO Auto-generated method stub
		return new String[] { "학번", "학과", "이름", "1과목", "2과목", "3과목", "총점", "평균", "평어", "평점" };
	}

	@Override
	protected void setTebleModelMode() {
		setTableCellAlign(SwingConstants.CENTER, 0, 1);
		setTableCellAlign(SwingConstants.RIGHT, 2, 3, 4, 5, 6, 7, 9);
		// 컬럼별 간격 조정
//				setTableCellWidth(100,100,80,80,80,80,100); 10개

		// 조건별 행 색깔 변경
		setTableCellcondition(8);

	}

	@Override
	public Object[] toArray(Student s) {
		// TODO Auto-generated method stub
		return new Object[] { s.getNo(), s.getDeptno().getDeptname(), s.getName(),  s.getScores().get(0).getScoer(),
				s.getScores().get(1).getScoer(), s.getScores().get(2).getScoer(), s.getTotal(), s.getAvg(), s.getRank(),
				s.getRanksco() };
	}

	@Override
	protected void initList(String where) {
		list = service.selectByWhere(where);

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
}
