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

import shin_student2.dto.Student;
import shin_student2.service.ScoreService;
import shin_student2.ui.exception.InvalidCheckException;
import shin_student2.ui.exception.SqlConstraintException;
import shin_student2.ui.scoPanel.ScoManagPanel;
import shin_student2.ui.table.ScoTablePanel;

public class scoManag extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnUp;
	private ScoManagPanel pCenter;
	private ScoreService service = ScoreService.getInstance();
	private ScoTablePanel table;

	public JButton getBtnUp() {
		return btnUp;
	}

	public scoManag() {
		initialize();
	}

	private void initialize() {
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

		JButton btnClear = new JButton("취소");
		pBtn.add(btnClear);
	}

	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource() == btnUp) {
				do_btnUp_actionPerformed(e);
			}
		} catch (InvalidCheckException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
	}

	protected void do_btnUp_actionPerformed(ActionEvent e) {
		Student student = pCenter.getStudent();
		service.modifyScores(student);
		table.loadData("");
	}

	public void setvalue(Student student) {
		pCenter.setvalue(student);
	}

	public void upTable(ScoTablePanel scoTablePanel) {
		this.table = scoTablePanel;
	}

}
