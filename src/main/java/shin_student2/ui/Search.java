package shin_student2.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import shin_student2.dto.Attendings;
import shin_student2.dto.Days;
import shin_student2.dto.Department;
import shin_student2.dto.Militarys;
import shin_student2.dto.Student;
import shin_student2.service.StudentService;
import shin_student2.ui.scoPanel.ScoTopPanel;
import shin_student2.ui.stdPanel.StdLHPanel;
import shin_student2.ui.table.ScoTablePanel;
import shin_student2.ui.table.StdTablePanel;

public class Search extends JFrame implements ActionListener {

	private JPanel contentPane;
	private StudentService service = StudentService.getInstance();
	private StdLHPanel pStdLH;
	private StdTablePanel pStdTable;
	private JButton btnSearch;
	private ScoTopPanel pTopSearch;
	private ScoTablePanel pScoTable;

	public Search() {
		
		initialize();
		pStdLH.UPTable(pStdTable);
	}

	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 941, 555);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setEnabled(true);
		contentPane.add(tabbedPane, BorderLayout.CENTER);

		JPanel pStdManag = new JPanel();
		pStdManag.setBorder(new EmptyBorder(10, 10, 10, 10));
		tabbedPane.addTab("학생 관리", null, pStdManag, null);
		pStdManag.setLayout(new GridLayout(0, 2, 10, 0));

		pStdLH = new StdLHPanel();
		pStdLH.getBtnSearch().addActionListener(this);
		pStdManag.add(pStdLH);
		
		
		JPanel pStdRH = new JPanel();
		pStdManag.add(pStdRH);
		pStdRH.setLayout(new BorderLayout(0, 0));
		
		pStdTable = new StdTablePanel();
		pStdTable.setService(service);
		
		pStdTable.loadData("");
		pStdRH.add(pStdTable, BorderLayout.CENTER);

		JPanel pScoManag = new JPanel();
		tabbedPane.addTab("성적 관리", null, pScoManag, null);
		pScoManag.setLayout(new BorderLayout(0, 0));

		JPanel pScoTop = new JPanel();
		pScoTop.setBorder(new EmptyBorder(0, 20, 0, 20));
		pScoManag.add(pScoTop, BorderLayout.NORTH);
		pScoTop.setLayout(new BorderLayout(0, 0));

		pTopSearch = new ScoTopPanel();
		pScoTop.add(pTopSearch, BorderLayout.CENTER);

		btnSearch = new JButton("검색");
		btnSearch.addActionListener(this);
		pScoTop.add(btnSearch, BorderLayout.EAST);
		
		JPanel pScoBottom = new JPanel();
		pScoManag.add(pScoBottom, BorderLayout.CENTER);
		pScoBottom.setLayout(new BorderLayout(0, 0));
		
		pScoTable = new ScoTablePanel();
		pScoTable.setService(service);
		pScoTable.loadData("");
		pScoBottom.add(pScoTable, BorderLayout.CENTER);
	}
	



	

	

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnSearch) {
			do_btnSearch_actionPerformed(arg0);
		}
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
	protected void do_btnSearch_actionPerformed(ActionEvent arg0) {
		Student std = pTopSearch.getStudent();
		String where = "";
		if (std instanceof Student) {
			where = "where ";
			if (std.getName().equals("")){}else {
				if (where.equals("where ")) {} else {where += " and ";}
				where += ("name = " + "'" + std.getName() + "'");
			}
			if (std.getDeptno() instanceof Department) {
				if (where.equals("where ")) {} else {where += " and ";}
				where += ("deptno = " + std.getDeptno().getDeptno());
			}
			if (std.getGrade() != 0) {
				if (where.equals("where ")) {} else {where += " and ";}
				where += ("grade = " + std.getGrade());
			}
			if (std.getRank().equals("")){}else {
				if (where.equals("where ")) {} else {where += " and ";}
				where += ("rank = " + "'" + std.getRank() + "'");
			}

		}
		pScoTable.loadData(where);
	}
}
