package shin_student2.ui.scoPanel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.JFreeChart;

import shin_student2.dto.Department;
import shin_student2.dto.Student;
import shin_student2.service.StudentService;
import shin_student2.ui.table.ScoTablePanel;

public class ScoPanel extends JPanel implements ActionListener{

	private JButton btnSearch;
	private ScoTopPanel pTopSearch;
	private ScoTablePanel pScoTable;
	private StudentService service = StudentService.getInstance();
	private ScoChart panel_1;


	public ScoTablePanel getpScoTable() {
		return pScoTable;
	}
	/**
	 * Create the panel.
	 */
	public ScoPanel() {

		initialize();
		panel_1.setList(pScoTable.getList());
		JFreeChart chart = panel_1.getchart2();
		panel_1.getChartPanel().setChart(chart);
		pScoTable.setPanel_1(panel_1);
	}
	
	private void initialize() {
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setLayout(new BorderLayout(10, 10));
		
		pScoTable = new ScoTablePanel();
		add(pScoTable, BorderLayout.CENTER);
		pScoTable.setService(service);
		pScoTable.loadData("");
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(10, 10));
		
		pTopSearch = new ScoTopPanel();
		panel.add(pTopSearch);
		
		btnSearch = new JButton("검색");
		btnSearch.addActionListener(this);
		panel.add(btnSearch, BorderLayout.EAST);
		
		
		panel_1 = new ScoChart();
		add(panel_1, BorderLayout.SOUTH);
	}
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnSearch) {
			do_btnSearch_actionPerformed(arg0);
		}
		
	}

	
	protected void do_btnSearch_actionPerformed(ActionEvent arg0) {
		Student std = pTopSearch.getStudent();
		String where = "";
		if (std instanceof Student) {
			if(!std.getName().equals("")&&std.getDeptno() instanceof Department&&std.getGrade() != 0) {
			where = "where ";
			}
			
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
			

		}
		pScoTable.loadData(where);
			
		List<Student> lists = pScoTable.getList();
		List<Student> temp =null;
		if (lists != null && std != null) {
			String a = std.getRank().getRank();
			temp = new ArrayList<Student>();
			if (!std.getRank().getRank().equals("")) {
				for (int i = 0; i < lists.size(); i++) {
					String a2 = lists.get(i).getRank().getRank();
					if (a2.equals(a)) {
						System.out.println(a2+":"+a);
						temp.add(lists.get(i));
					}
				}
				pScoTable.loadData2(temp);
			}
		}
		
		panel_1.setList(pScoTable.getList());
	}
}
