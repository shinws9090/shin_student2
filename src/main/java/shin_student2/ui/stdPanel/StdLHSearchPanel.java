package shin_student2.ui.stdPanel;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import shin_student2.dto.Attendings;
import shin_student2.dto.Days;
import shin_student2.dto.Department;
import shin_student2.dto.Militarys;
import shin_student2.dto.Student;
import shin_student2.service.ComboBoxList;
import shin_student2.service.ManagService;
import shin_student2.ui.stdPanel.pop.AttendingsPop;
import shin_student2.ui.stdPanel.pop.DaysPop;
import shin_student2.ui.stdPanel.pop.DeptPop;
import shin_student2.ui.stdPanel.pop.MiliterysPop;

public class StdLHSearchPanel extends JPanel {
	private JComboBox<Days> cbDayTime;
	private JComboBox<String> cbGrade;
	private JComboBox<Department> cbDept;
	private JComboBox<Attendings> cbAtd;
	private JComboBox<String> cbSocial;
	private JComboBox<Militarys> cbMilt;
	private ComboBoxList listService = ComboBoxList.getInstance();
	private ManagService managService = new ManagService();
	private JLabel lblDept;
	private JPopupMenu popupMenu;
	private JMenu mnDept;
	private DeptPop panel;
	private JMenu mnDays;
	private JMenu mnAtd;
	private JMenu mnMit;
	private JLabel lblNewLabel;
	private JSeparator separator;
	private DaysPop panel_1;
	private MiliterysPop panel_2;
	private AttendingsPop panel_3;
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
		
		popupMenu = new JPopupMenu();
		addPopup(this, popupMenu);
		
		lblNewLabel = new JLabel("코드관리");
		popupMenu.add(lblNewLabel);
		
		separator = new JSeparator();
		popupMenu.add(separator);
		
		mnDept = new JMenu("학과");
		popupMenu.add(mnDept);
		
		panel = new DeptPop();
		mnDept.add(panel);
		panel.setPreferredSize(new Dimension(300, 250));
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		panel.setManagService(managService);
		panel.setSearch(this);
		
		mnDays = new JMenu("주야");
		popupMenu.add(mnDays);
		
		panel_1 = new DaysPop();
		mnDays.add(panel_1);
		panel_1.setPreferredSize(new Dimension(300, 250));
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		panel_1.setManagService(managService);
		panel_1.setSearch(this);
		
		mnAtd = new JMenu("병역");
		popupMenu.add(mnAtd);
		
		panel_2 = new MiliterysPop();
		mnAtd.add(panel_2);
		panel_2.setPreferredSize(new Dimension(300, 250));
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
		panel_2.setManagService(managService);
		panel_2.setSearch(this);
		
		mnMit = new JMenu("학적");
		popupMenu.add(mnMit);
		
		panel_3 = new AttendingsPop();
		mnMit.add(panel_3);
		panel_3.setPreferredSize(new Dimension(300, 250));
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));
		panel_3.setManagService(managService);
		panel_3.setSearch(this);
		
		setLayout(new GridLayout(0, 2, 20, 20));
		
		JLabel lblDayTime = new JLabel("주야구분");
		lblDayTime.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblDayTime);
	
		cbDayTime = new JComboBox<Days>();
		add(cbDayTime);
		
		lblDept = new JLabel("학과");
		lblDept.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblDept);
		
		cbDept = new JComboBox<Department>();
		add(cbDept);
		
		JLabel lblGrade = new JLabel("학년");
		lblGrade.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblGrade);
		
		cbGrade = new JComboBox(listService.ComboListSelect("students", "grade"));
		add(cbGrade);
		
		JLabel lblAtd = new JLabel("학적구분");
		lblAtd.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblAtd);
		
		cbAtd = new JComboBox<Attendings>();
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
		
		cbMilt = new JComboBox<Militarys>();
		add(cbMilt);
		loadComboBox();
		clearTf();
	}
	
	public void loadComboBox() {
		DefaultComboBoxModel<Days> dayModel = new DefaultComboBoxModel<Days>(new Vector<Days>(listService.DaysComboBox()));
		cbDayTime.setModel(dayModel);
		DefaultComboBoxModel<Department> deptModel = new DefaultComboBoxModel<Department>(new Vector<Department>(listService.DeptComboBox()));
		cbDept.setModel(deptModel);
		DefaultComboBoxModel<Attendings> AtdModel = new DefaultComboBoxModel<Attendings>(new Vector<Attendings>(listService.AtdComboBox()));
		cbAtd.setModel(AtdModel);
		DefaultComboBoxModel<Militarys> militModel = new DefaultComboBoxModel<Militarys>(new Vector<Militarys>(listService.MiltComboBox()));
		cbMilt.setModel(militModel);
	}
	
	public Student getStudent() {
		int idx =cbSocial.getSelectedIndex()
				+cbDayTime.getSelectedIndex()+cbDept.getSelectedIndex()
				+cbGrade.getSelectedIndex()+cbAtd.getSelectedIndex()
				+cbMilt.getSelectedIndex();
		
		if(idx <= 0) {
			System.out.println("Asdasd");
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
	
	public void clearTf() {
		cbSocial.setSelectedIndex(0);
		cbSocial.setSelectedIndex(0);
		cbDayTime.setSelectedIndex(0);
		cbDept.setSelectedIndex(0);
		cbGrade.setSelectedIndex(0);
		cbAtd.setSelectedIndex(0);
		cbMilt.setSelectedIndex(0);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
