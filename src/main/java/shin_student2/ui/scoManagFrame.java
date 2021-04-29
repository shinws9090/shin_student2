package shin_student2.ui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.JFreeChart;

import shin_student2.dto.Student;
import shin_student2.service.ScoreService;
import shin_student2.ui.exception.InvalidCheckException;
import shin_student2.ui.exception.SqlConstraintException;
import shin_student2.ui.scoPanel.ScoChart;
import shin_student2.ui.scoPanel.ScoManagPanel;
import shin_student2.ui.table.ScoTablePanel;

public class scoManagFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnUp;
	private ScoManagPanel pCenter;
	private ScoreService service = ScoreService.getInstance();
	private ScoTablePanel table;
	private JButton btnClear;

	public JButton getBtnUp() {
		return btnUp;
	}

	public scoManagFrame() {
		initialize();
	}

	private void initialize() {
		setTitle("학생 관리프로그램");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 246);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel pTitle = new JPanel();
		contentPane.add(pTitle, BorderLayout.NORTH);

		JLabel lblTitle = new JLabel("성적 수정");
		lblTitle.setFont(new Font("굴림", Font.BOLD, 25));
		pTitle.add(lblTitle);

		pCenter = new ScoManagPanel();
		contentPane.add(pCenter, BorderLayout.CENTER);

		JPanel pBtn = new JPanel();
		contentPane.add(pBtn, BorderLayout.SOUTH);

		btnUp = new JButton("저장");
		btnUp.addActionListener(this);
		pBtn.add(btnUp);

		btnClear = new JButton("취소");
		btnClear.addActionListener(this);
		pBtn.add(btnClear);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnClear) {
			do_btnClear_actionPerformed(e);
		}
		try {
			if (e.getSource() == btnUp) {
				do_btnUp_actionPerformed(e);
			}
		} catch (InvalidCheckException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
	}
	private ScoChart panel_1;
	
	public void setPanel_1(ScoChart panel_1) {
		this.panel_1 = panel_1;
	}

	protected void do_btnUp_actionPerformed(ActionEvent e) {
		Student student = pCenter.getStudent();
		if(student !=null) {
			service.modifyScores(student);
			table.loadData("");
			panel_1.setList(table.getList());
			JFreeChart chart = panel_1.getchart2();
			panel_1.getChartPanel().setChart(chart);
			setVisible(false);
		}
	}

	public void setvalue(Student student) {
		pCenter.setvalue(student);
	}

	public void upTable(ScoTablePanel scoTablePanel) {
		this.table = scoTablePanel;
	}

	protected void do_btnClear_actionPerformed(ActionEvent e) {
		pCenter.clearTf();
	}
}
