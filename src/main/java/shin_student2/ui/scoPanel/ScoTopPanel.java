package shin_student2.ui.scoPanel;

import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import shin_student2.dto.Department;
import shin_student2.dto.Rank;
import shin_student2.dto.Student;
import shin_student2.service.ComboBoxList;

public class ScoTopPanel extends JPanel {
	private JTextField tfName;
	private ComboBoxList listService = ComboBoxList.getInstance();
	private JComboBox cbDept;
	private JComboBox cbGrade;
	private JComboBox cbRank;

	/**
	 * Create the panel.
	 */
	public ScoTopPanel() {

		initialize();
	}

	private void initialize() {
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setLayout(new GridLayout(1, 0, 10, 10));

		JLabel lblDept = new JLabel("학과");
		lblDept.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblDept);

		cbDept = new JComboBox<>(new Vector<Department>(listService.DeptComboBox()));
		add(cbDept);

		JLabel lblGrade = new JLabel("학년");
		lblGrade.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblGrade);

		cbGrade = new JComboBox<>(listService.ComboListSelect("students", "grade"));
		add(cbGrade);

		JLabel lblName = new JLabel("성명");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblName);

		tfName = new JTextField();
		add(tfName);
		tfName.setColumns(10);
		
		JLabel lblRank = new JLabel("등급");
		lblRank.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblRank);
		String[] arr = {"","A","B","C","D","F"};
		cbRank = new JComboBox<>(arr);
		add(cbRank);
	}

	public Student getStudent() {
		int idx = cbDept.getSelectedIndex() + cbGrade.getSelectedIndex() + cbRank.getSelectedIndex()
		+(tfName.getText().equals("")?0:1);

		if (idx <= 0) {
			return null;
		}
		
		String name = tfName.getText();
		
		Department deptno = (Department) cbDept.getSelectedItem();
		deptno = deptno.getDeptno() == 0 ? null : (Department) cbDept.getSelectedItem();

		int grade = 0;
		if ((String) cbGrade.getSelectedItem() != "")
			grade = Integer.parseInt((String) cbGrade.getSelectedItem());
		
		String r = (String) cbRank.getSelectedItem();
		
		return new Student(name, deptno, grade, new Rank(r));
	}

}
