package shin_student2.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import shin_student2.ui.scoPanel.ScoPanel;
import shin_student2.ui.stdPanel.StdPanel;
import shin_student2.ui.stdPanel.pop.AttendingsPop;
import shin_student2.ui.stdPanel.pop.DaysPop;
import shin_student2.ui.stdPanel.pop.DeptPop;
import shin_student2.ui.stdPanel.pop.MiliterysPop;

public class SearchFrame extends JFrame implements ChangeListener {

	private JPanel contentPane;
	private StdPanel pStdManag;
	private ScoPanel pScoManag;
	private JTabbedPane tabbedPane;
	private JPanel codeManag;
	private JTabbedPane tabbedPane_1;
	private DeptPop panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	

	public SearchFrame() {
		
		initialize();
	}

	private void initialize() {
		setTitle("학생 관리프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 941, 555);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addChangeListener(this);
		tabbedPane.setEnabled(true);
		contentPane.add(tabbedPane, BorderLayout.CENTER);

		pStdManag = new StdPanel();
		pStdManag.setBorder(new EmptyBorder(10, 10, 10, 10));
		tabbedPane.addTab("학생 관리", null, pStdManag, null);
		pStdManag.setLayout(new GridLayout(0, 2, 10, 0));
		
		pScoManag = new ScoPanel();
		tabbedPane.addTab("성적 관리", null, pScoManag, null);
		
		codeManag = new JPanel();
		tabbedPane.addTab("코드 관리", null, codeManag, null);
		codeManag.setLayout(new BorderLayout(0, 0));
		
		tabbedPane_1 = new JTabbedPane(JTabbedPane.LEFT);
		codeManag.add(tabbedPane_1);
		
		panel = new DeptPop();
		tabbedPane_1.addTab("학과 관리", null, panel, null);
		
		panel_1 = new AttendingsPop();
		tabbedPane_1.addTab("학적 관리", null, panel_1, null);
		
		panel_2 = new DaysPop();
		tabbedPane_1.addTab("주야 관리", null, panel_2, null);
		
		panel_3 = new MiliterysPop();
		tabbedPane_1.addTab("병역 관리", null, panel_3, null);
	}
	



	

	

	
	public void stateChanged(ChangeEvent e) {
		
		
		if (tabbedPane.getSelectedIndex()==2) {
			codeManagStateChanged(e);
		}else {
			do_tabbedPane_stateChanged(e);
		}
	}
	protected void do_tabbedPane_stateChanged(ChangeEvent e) {
		if(pStdManag!=null&&pScoManag!=null) {
		pStdManag.getpStdTable().loadData("");
		pScoManag.getpScoTable().loadData("");
		}
		setBounds(getBounds().x, getBounds().y, 941, 555);
	}
	protected void codeManagStateChanged(ChangeEvent e) {
		setBounds(getBounds().x, getBounds().y, 600, 555);
	}
}
