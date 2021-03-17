package shin_student2.ui.scoPanel;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import shin_student2.dto.Student;
import shin_student2.ui.exception.InvalidCheckException;

import java.awt.GridLayout;

public class ScoManagPanel extends JPanel {
	private JTextField tfDept;
	private JTextField tfSub1;
	private JTextField tfGrade;
	private JTextField tfSub2;
	private JTextField tfNo;
	private JTextField tfSub3;
	private JTextField tfName;
	private Student student;

	/**
	 * Create the panel.
	 */
	public ScoManagPanel() {

		initialize();
		tfDept.setEditable(false);
		tfGrade.setEditable(false);
		tfNo.setEditable(false);
		tfName.setEditable(false);

		JLabel label = new JLabel("");
		add(label);
	}

	private void initialize() {
		this.setBounds(12, 74, 315, 156);
		setLayout(new GridLayout(0, 4, 10, 10));

		JLabel lblDept = new JLabel("학과 : ");
		add(lblDept);

		tfDept = new JTextField();
		add(tfDept);
		tfDept.setColumns(10);

		JLabel lblSub1 = new JLabel("1과목 : ");
		add(lblSub1);

		tfSub1 = new JTextField();
		add(tfSub1);
		tfSub1.setColumns(6);

		JLabel lblGrade = new JLabel("학년 : ");
		add(lblGrade);

		tfGrade = new JTextField();
		tfGrade.setColumns(10);
		add(tfGrade);

		JLabel lblSub2 = new JLabel("2과목 : ");
		add(lblSub2);

		tfSub2 = new JTextField();
		tfSub2.setColumns(6);
		add(tfSub2);

		JLabel lblNo = new JLabel("학번 : ");
		add(lblNo);

		tfNo = new JTextField();
		tfNo.setColumns(10);
		add(tfNo);

		JLabel lblSub3 = new JLabel("3과목 : ");
		add(lblSub3);

		tfSub3 = new JTextField();
		tfSub3.setColumns(6);
		add(tfSub3);

		JLabel lblName = new JLabel("이름 : ");
		add(lblName);

		tfName = new JTextField();
		tfName.setColumns(10);
		add(tfName);

	}

	public Student getStudent() {
		if (tfSub1.getText().equals("") || tfSub2.getText().equals("") || tfSub3.getText().equals("")) {
			throw new InvalidCheckException();
		}
		try {
			student.getScores().get(0).setScoer(Integer.parseInt(tfSub1.getText()));
			student.getScores().get(1).setScoer(Integer.parseInt(tfSub2.getText()));
			student.getScores().get(2).setScoer(Integer.parseInt(tfSub3.getText()));
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "성적이 이상함다");
			return null;
		}
		return student;
	}

	public void setvalue(Student student) {
		this.student = student;
		
		tfDept.setText(student.getDeptno().getDeptname());
		tfSub1.setText(student.getScores().get(0).getScoer() + "");
		tfGrade.setText(student.getGrade() + "");
		tfSub2.setText(student.getScores().get(1).getScoer() + "");
		tfNo.setText(student.getNo() + "");
		tfSub3.setText(student.getScores().get(2).getScoer() + "");
		tfName.setText(student.getName());

	}

	public void clearTf() {
		tfSub1.setText("");
		tfSub2.setText("");
		tfSub3.setText("");

	}

}
