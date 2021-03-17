package shin_student2.ui.stdPanel;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Date;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.toedter.calendar.JDateChooser;

import shin_student2.dto.Attendings;
import shin_student2.dto.Days;
import shin_student2.dto.Department;
import shin_student2.dto.Militarys;
import shin_student2.dto.Student;
import shin_student2.service.ComboBoxList;
import shin_student2.ui.exception.InvalidCheckException;

public class StdManagPanel extends JPanel implements ActionListener {
	private JComboBox cbDayTime;
	private JComboBox cbDept;
	private JComboBox cbGrade;
	private JTextField tfName;
	private JTextField tfNo;
	private JComboBox cbSocial;
	private JComboBox cbMilt;
	private JComboBox cbAtd;
	private ComboBoxList dao = ComboBoxList.getInstance();
	private JDateChooser chBirthday;
	private JButton btnPic;
	private String imgPath = System.getProperty("user.dir") + File.separator + "images" + File.separator;
	private JLabel lblPic;
	private File chooserFile;

	public File getChooserFile() {
		return chooserFile;
	}

	public StdManagPanel() {

		initialize();
	}

	private void initialize() {
		setBounds(20, 119, 340, 266);
		setLayout(new GridLayout(0, 2, 10, 10));

		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		add(panel);
		panel.setLayout(new BorderLayout(10, 10));

		lblPic = new JLabel("");
		lblPic.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblPic, BorderLayout.CENTER);

		btnPic = new JButton("사진불러오기");
		btnPic.addActionListener(this);
		panel.add(btnPic, BorderLayout.SOUTH);

		JPanel panel_1 = new JPanel();
		add(panel_1);
		panel_1.setLayout(new GridLayout(0, 2, 0, 5));

		JLabel lblDays = new JLabel("주야구분");
		lblDays.setHorizontalAlignment(SwingConstants.CENTER);
		lblDays.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel_1.add(lblDays);

		cbDayTime = new JComboBox(new Vector(dao.DaysComboBox()));
		panel_1.add(cbDayTime);

		JLabel lblDept = new JLabel("학         과");
		lblDept.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblDept);

		cbDept = new JComboBox(new Vector(dao.DeptComboBox()));
		panel_1.add(cbDept);

		JLabel lblGrade = new JLabel("학         년");
		lblGrade.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblGrade);

		cbGrade = new JComboBox(dao.ComboListSelect("students", "grade"));
		panel_1.add(cbGrade);

		JLabel lblName = new JLabel("성         명");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblName);

		tfName = new JTextField();
		tfName.setHorizontalAlignment(SwingConstants.CENTER);
		tfName.setColumns(6);
		panel_1.add(tfName);

		JLabel lblNo = new JLabel("학         번");
		lblNo.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNo);

		tfNo = new JTextField();
		tfNo.setHorizontalAlignment(SwingConstants.CENTER);
		tfNo.setColumns(6);
		panel_1.add(tfNo);

		JLabel lblAtd = new JLabel("학적구분");
		lblAtd.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblAtd);

		cbAtd = new JComboBox(new Vector(dao.AtdComboBox()));
		panel_1.add(cbAtd);

		JLabel lblBirthday = new JLabel("생년월일");
		lblBirthday.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblBirthday);

		chBirthday = new JDateChooser();
		panel_1.add(chBirthday);

		JLabel lblSocial = new JLabel("성         별");
		lblSocial.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblSocial);
		String[] a = { "", "남", "여" };
		cbSocial = new JComboBox(a);
		panel_1.add(cbSocial);

		JLabel lblMilt = new JLabel("병역사항");
		lblMilt.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblMilt);

		cbMilt = new JComboBox<Militarys>(new Vector(dao.MiltComboBox()));
		panel_1.add(cbMilt);
	}

	public Student getStudent(){
		if (cbSocial.getSelectedIndex() == 0 || cbDayTime.getSelectedIndex() == 0 || cbDept.getSelectedIndex() == 0
				|| cbGrade.getSelectedIndex() == 0 || cbAtd.getSelectedIndex() == 0 || cbMilt.getSelectedIndex() == 0
				|| tfNo.getText().equals("") || chBirthday.getDateFormatString().equals("")
				|| tfName.getText().equals("")||chooserFile==null) {
			
			throw new InvalidCheckException();
		}
				
		int no = Integer.parseInt(tfNo.getText());

		String name = tfName.getText();

		Date birthday = new Date(chBirthday.getDate().getTime());

		int social = 0;
		if (cbSocial.getSelectedItem().equals("남")) {
			social = 1000000;
		} else if (cbSocial.getSelectedItem().equals("여")) {
			social = 2000000;
		}

		Days dayno = (Days) cbDayTime.getSelectedItem();
		dayno = dayno.getDayno() == 0 ? null : (Days) cbDayTime.getSelectedItem();
		Department deptno = (Department) cbDept.getSelectedItem();
		deptno = deptno.getDeptno() == 0 ? null : (Department) cbDept.getSelectedItem();

		int grade = 0;
		if ((String) cbGrade.getSelectedItem() != "")
			grade = Integer.parseInt((String) cbGrade.getSelectedItem());
		Attendings atdno = (Attendings) cbAtd.getSelectedItem();
		atdno = atdno.getAtdno() == null ? null : (Attendings) cbAtd.getSelectedItem();
		Militarys miltno = (Militarys) cbMilt.getSelectedItem();
		miltno = miltno.getMiltno() == null ? null : (Militarys) cbMilt.getSelectedItem();

		String pic = chooserFile.getName();

		return new Student(no, name, birthday, social, dayno, deptno, grade, atdno, miltno, pic);
	}

	public void setvalue(Student std) {

		cbDayTime.setSelectedItem(std.getDayno());
		cbDept.setSelectedItem(std.getDeptno());

		cbGrade.setSelectedItem(std.getGrade() + "");

		tfName.setText(std.getName());
		tfNo.setText(std.getNo() + "");
		chBirthday.setDate(std.getBirthday());

		String str = "남";
		if (std.getSocial() == 2000000) {
			str = "여";
		}
		cbSocial.setSelectedItem(str);
		// 객체가 달라서 안되는듯
		cbMilt.setSelectedItem(std.getMiltno());
		cbAtd.setSelectedItem(std.getAtdno());

		System.out.println(imgPath + std.getPic());
		lblPic.setIcon(new ImageIcon(imgPath + std.getPic()));
		chooserFile = new File(imgPath + std.getPic());
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnPic) {
			do_btnNewButton_actionPerformed(arg0);
		}
	}

	protected void do_btnNewButton_actionPerformed(ActionEvent arg0) {
		String openPath = "C:\\Users\\lenovo\\Downloads";
		JFileChooser chooser = new JFileChooser(openPath);
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF & PNG image", "jpg", "gif", "png");
		chooser.setFileFilter(filter);
		int res = chooser.showOpenDialog(null);
		if (res != JFileChooser.APPROVE_OPTION) {
			JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다.", "경고", JOptionPane.WARNING_MESSAGE);
			return;
		} else {

			chooserFile = chooser.getSelectedFile();
			lblPic.setIcon(new ImageIcon(chooserFile.getPath()));

		}
	}

	public void clearValue() {

		cbDayTime.setSelectedIndex(0);
		cbDept.setSelectedIndex(0);

		cbGrade.setSelectedIndex(0);

		tfName.setText("");
		tfNo.setText("");
		chBirthday.setDate(null);

		
		cbSocial.setSelectedIndex(0);
		cbMilt.setSelectedIndex(0);
		cbAtd.setSelectedIndex(0);

		lblPic.setIcon(null);
		chooserFile = null;
	}

}
