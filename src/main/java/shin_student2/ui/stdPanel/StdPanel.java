package shin_student2.ui.stdPanel;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import shin_student2.dto.Attendings;
import shin_student2.dto.Days;
import shin_student2.dto.Department;
import shin_student2.dto.Militarys;
import shin_student2.dto.Student;
import shin_student2.service.StudentService;
import shin_student2.ui.table.StdTablePanel;

public class StdPanel extends JPanel implements ActionListener{

	private StdLHPanel pStdLH;
	private StdTablePanel pStdTable;
	private StudentService service = StudentService.getInstance();

	/**
	 * Create the panel.
	 */
	public StdPanel() {

		initialize();
	}
	private void initialize() {
		setLayout(new GridLayout(0, 2, 0, 0));
		
		pStdLH = new StdLHPanel();
		pStdLH.getBtnSearch().addActionListener(this);
		add(pStdLH);
		
		pStdTable = new StdTablePanel();
		pStdTable.setService(service);
		pStdTable.loadData("");
		add(pStdTable);
		pStdLH.setTable(pStdTable);
	}
	public void actionPerformed(ActionEvent arg0) {
		
		if (arg0.getSource() == pStdLH.getBtnSearch()) {
			do_pStdLHBtnSearch_actionPerformed(arg0);
		}
	}

	protected void do_pStdLHBtnSearch_actionPerformed(ActionEvent arg0) {
		Student std = pStdLH.getStudent();
		String where = "";
		if (std instanceof Student) {
			where = "where ";
			if (std.getName().equals("")){}else {
				if (where.equals("where ")) {} else {where += " and ";}
				where += ("name = " + "'" + std.getName() + "'");
			}
			if (std.getNo() != 0) {
				if (where.equals("where ")) {} else {where += " and ";}
				where += ("stdno = " + std.getNo());
			}
			if (std.getSocial() != 0) {
				if (where.equals("where ")) {} else {where += " and ";}
				where += ("social = " + std.getSocial());
			}
			if (std.getDayno() instanceof Days) {
				if (where.equals("where ")) {} else {where += " and ";}
				where += ("dayTimeno = " + std.getDayno().getDayno());
			}
			if (std.getDeptno() instanceof Department) {
				if (where.equals("where ")) {} else {where += " and ";}
				where += ("deptno = " + std.getDeptno().getDeptno());
			}
			if (std.getGrade() != 0) {
				if (where.equals("where ")) {} else {where += " and ";}
				where += ("grade = " + std.getGrade());
			}
			if (std.getAtdno() instanceof Attendings ) {
				if (where.equals("where ")) {} else {where += " and ";}
				where += ("atdno = " + "'" + std.getAtdno().getAtdno() + "'");
			}
			if (std.getMiltno() instanceof Militarys ) {
				if (where.equals("where ")) {} else {where += "and ";}
				where += ("miltno = " + "'" + std.getMiltno().getMiltno() + "'");
			}

		}
		pStdTable.loadData(where);
		
		
	}

	
}
