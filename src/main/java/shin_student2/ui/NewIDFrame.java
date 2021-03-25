package shin_student2.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import shin_student2.dto.ID;
import shin_student2.service.IDService;
import shin_student2.ui.exception.InvalidCheckException;
import shin_student2.ui.exception.SqlConstraintException;

public class NewIDFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tfID;
	private JButton btnNewID;
	private IDService service;
	private JPasswordField tfPass1;
	private JLabel lblPass2;
	private JPasswordField tfPass2;
	private JLabel lblEmail;
	private JTextField tfEmail;
	private JPanel p1;
	private JLabel lblPassComfirm;
	private JPanel p2;

	public NewIDFrame() {
		setTitle("학생 관리프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 304);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JLabel lblTitle = new JLabel("회원가입");
		lblTitle.setForeground(SystemColor.window);
		lblTitle.setOpaque(true);
		lblTitle.setBackground(SystemColor.activeCaption);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("굴림", Font.BOLD, 25));
		contentPane.add(lblTitle, BorderLayout.NORTH);

		JPanel pCenter = new JPanel();
		pCenter.setBackground(SystemColor.window);
		pCenter.setBorder(new EmptyBorder(20, 50, 20, 50));
		contentPane.add(pCenter, BorderLayout.CENTER);
		pCenter.setLayout(new GridLayout(0, 2, 10, 10));

		JLabel lblID = new JLabel("아이디");
		lblID.setHorizontalAlignment(SwingConstants.CENTER);
		pCenter.add(lblID);

		tfID = new JTextField();
		pCenter.add(tfID);
		tfID.setColumns(10);

		JLabel lblPass1 = new JLabel("비밀번호");
		lblPass1.setHorizontalAlignment(SwingConstants.CENTER);
		pCenter.add(lblPass1);

		tfPass1 = new JPasswordField();
		tfPass1.setEchoChar('뀨');
		pCenter.add(tfPass1);
		tfPass1.getDocument().addDocumentListener(listener);

		lblPass2 = new JLabel("비밀번호확인");
		lblPass2.setHorizontalAlignment(SwingConstants.CENTER);
		pCenter.add(lblPass2);

		tfPass2 = new JPasswordField();
		tfPass2.setEchoChar('뀨');
		pCenter.add(tfPass2);
		tfPass2.getDocument().addDocumentListener(listener);

		p1 = new JPanel();
		p1.setBackground(Color.WHITE);
		pCenter.add(p1);

		lblPassComfirm = new JLabel("비밀번호 확인");
		lblPassComfirm.setForeground(Color.RED);
		lblPassComfirm.setHorizontalAlignment(SwingConstants.CENTER);
		pCenter.add(lblPassComfirm);

		lblEmail = new JLabel("이메일");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		pCenter.add(lblEmail);

		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		pCenter.add(tfEmail);

		btnNewID = new JButton("회원가입");
		btnNewID.addActionListener(this);

		p2 = new JPanel();
		p2.setBackground(Color.WHITE);
		pCenter.add(p2);
		btnNewID.setBackground(Color.WHITE);
		pCenter.add(btnNewID);
	}

	DocumentListener listener = new DocumentListener() {

		@Override
		public void removeUpdate(DocumentEvent e) {
			if (String.valueOf(tfPass2.getPassword()).equals("") || String.valueOf(tfPass2.getPassword()).equals("")) {
				lblPassComfirm.setText("비밀번호 확인");
				lblPassComfirm.setForeground(Color.RED);
			}
			getPassConfirm();

		}

		@Override
		public void insertUpdate(DocumentEvent e) {
			getPassConfirm();

		}

		@Override
		public void changedUpdate(DocumentEvent e) {
			getPassConfirm();

		}
	};

	private void getPassConfirm() {
		String pw1 = String.valueOf(tfPass1.getPassword());
		String pw2 = String.valueOf(tfPass2.getPassword());
		if (pw1.equals(pw2)) {
			lblPassComfirm.setText("일치");
			lblPassComfirm.setForeground(Color.GREEN);
		} else {
			lblPassComfirm.setText("불일치");
			lblPassComfirm.setForeground(Color.RED);
		}

	}

	public ID getItem() {
		if (!lblPassComfirm.getText().equals("일치")) {
			throw new InvalidCheckException("비밀번호 불일치");
		}

		String id = tfID.getText();
		String pass = String.valueOf(tfPass1.getPassword());
		String email = tfEmail.getText();

		return new ID(id, pass, email);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			int res = service.insertId(getItem());
			if (res == 1) {
				JOptionPane.showMessageDialog(null, "회원가입 완료");
				setVisible(false);
			} else {
				JOptionPane.showMessageDialog(null, "가입 불가");
			}
		} catch (SqlConstraintException | InvalidCheckException e2) {
			JOptionPane.showMessageDialog(null, e2.getMessage());
		}

	}

	public void setService(IDService service) {
		this.service = service;
	}

}
