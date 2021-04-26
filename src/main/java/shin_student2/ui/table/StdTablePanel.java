package shin_student2.ui.table;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;

import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import shin_student2.dto.Student;
import shin_student2.service.StudentService;
import shin_student2.ui.stdManagFrame;
import shin_student2.ui.exception.NotSelectedException;

public class StdTablePanel extends SuperTable<Student> {
	private StudentService service;

	public StdTablePanel() {
	}

	@Override
	public String[] getColumnNames() {
		// TODO Auto-generated method stub
		return new String[] { "학생번호", "학생이름", "학적" };
	}

	@Override
	protected void setTebleModelMode() {
		setTableCellAlign(SwingConstants.CENTER, 0, 1, 2);

	}

	@Override
	public Object[] toArray(Student s) {
		return new Object[] { s.getNo(), s.getName(), s.getAtdno().getAttending() };
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
			stdManagFrame frame = new stdManagFrame();
			frame.setVisible(true);
			frame.getBtnInsetAndUpdate().setText("저장");
			frame.setvalue(student);
			
			frame.setTable(this);
		}
		if (e.getSource() == delete) {
			Student student = getItem();
			service.removeStudent(student);
			loadData("");
		}
		}catch(NotSelectedException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
	}
	
	@Override
	public Student getItem() {
		int idx = table.getSelectedRow();
		if(idx == -1) {
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
