package shin_student2.ui.stdPanel;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.border.EmptyBorder;

import shin_student2.dto.Attendings;
import shin_student2.dto.Days;
import shin_student2.dto.Department;
import shin_student2.dto.Militarys;
import shin_student2.dto.Score;
import shin_student2.dto.Student;
import shin_student2.dto.Subject;
import shin_student2.service.ComboBoxList;

public class StdLHSearchPanel extends JPanel {
	private JComboBox cbDayTime;
	private JComboBox cbGrade;
	private JComboBox cbDept;
	private JComboBox cbAtd;
	private JComboBox cbSocial;
	private JComboBox cbMilt;
	private ComboBoxList listService = ComboBoxList.getInstance();
	public JComboBox getCbDayTime() {
		return cbDayTime;
	}

	public JComboBox getCbGrade() {
		return cbGrade;
	}

	public JComboBox getCbDept() {
		return cbDept;
	}

	public JComboBox getCbAtd() {
		return cbAtd;
	}

	public JComboBox getCbSocial() {
		return cbSocial;
	}

	public JComboBox getCbMilt() {
		return cbMilt;
	}

	/**
	 * Create the panel.
	 */
	public StdLHSearchPanel() {
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setLayout(new GridLayout(0, 2, 20, 20));
		
		JLabel lblDayTime = new JLabel("주야구분");
		lblDayTime.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblDayTime);
	
		cbDayTime = new JComboBox<Days>(new Vector<Days>(listService.DaysComboBox()));
		add(cbDayTime);
		
		JLabel lblDept = new JLabel("학과");
		lblDept.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblDept);
		
		cbDept = new JComboBox<Department>(new Vector<Department>(listService.DeptComboBox()));
		add(cbDept);
		
		JLabel lblGrade = new JLabel("학년");
		lblGrade.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblGrade);
		
		cbGrade = new JComboBox<>(listService.ComboListSelect("students", "grade"));
		add(cbGrade);
		
		JLabel lblAtd = new JLabel("학적구분");
		lblAtd.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblAtd);
		
		cbAtd = new JComboBox<Attendings>(new Vector<Attendings>(listService.AtdComboBox()));
		add(cbAtd);
		
		JLabel lblSocial = new JLabel("성별");
		lblSocial.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblSocial);
		String[] social = {"","남","여"};
		cbSocial = new JComboBox(social);
		add(cbSocial);
		
		JLabel lblMilt = new JLabel("병역사항");
		lblMilt.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblMilt);
		
		cbMilt = new JComboBox<Militarys>(new Vector<Militarys>(listService.MiltComboBox()));
		add(cbMilt);
		clear();
	}
	public Student getStudent() {
		int idx =cbSocial.getSelectedIndex()
				+cbDayTime.getSelectedIndex()+cbDept.getSelectedIndex()
				+cbGrade.getSelectedIndex()+cbAtd.getSelectedIndex()
				+cbMilt.getSelectedIndex();
		
		if(idx <= 0) {
			return null;
		}
		
		
		int social=0;
		if(cbSocial.getSelectedItem().equals("남")){
			social = 1000000;
		}else if(cbSocial.getSelectedItem().equals("여")){
			social = 2000000;
		}
		
		
		Days dayno = (Days) cbDayTime.getSelectedItem();
		dayno = dayno.getDayno()==0?null:(Days) cbDayTime.getSelectedItem();
		Department deptno = (Department) cbDept.getSelectedItem();
		deptno = deptno.getDeptno()==0?null:(Department) cbDept.getSelectedItem();
		
		int grade =0;
		if((String) cbGrade.getSelectedItem() != "")
		grade = Integer.parseInt((String) cbGrade.getSelectedItem());
		Attendings atdno = (Attendings) cbAtd.getSelectedItem();
		atdno = atdno.getAtdno()==null?null:(Attendings) cbAtd.getSelectedItem();
		Militarys miltno = (Militarys) cbMilt.getSelectedItem();
		miltno = miltno.getMiltno()==null?null:(Militarys) cbMilt.getSelectedItem();
		return new Student(social, dayno, deptno, grade, atdno, miltno);
	}
	
	public void clear() {
		cbSocial.setSelectedIndex(0);
		cbSocial.setSelectedIndex(0);
		cbDayTime.setSelectedIndex(0);
		cbDept.setSelectedIndex(0);
		cbGrade.setSelectedIndex(0);
		cbAtd.setSelectedIndex(0);
		cbMilt.setSelectedIndex(0);
	}
}
