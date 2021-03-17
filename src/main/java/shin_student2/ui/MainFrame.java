package shin_student2.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import shin_student2.dto.ID;
import shin_student2.service.IDService;
import javax.swing.JPasswordField;

public class MainFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tfID;
	private JButton btnRogin;
	private JButton btnNewID;
	private IDService service;
	private JPasswordField tfPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public MainFrame() {
		service = new IDService();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 216);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JLabel lblTitle = new JLabel("학생관리 프로그램 로그인");
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
		tfID.getDocument().addDocumentListener(listener);

		JLabel lblPass = new JLabel("비밀번호");
		lblPass.setHorizontalAlignment(SwingConstants.CENTER);
		pCenter.add(lblPass);

		tfPass = new JPasswordField();
		tfPass.setEchoChar('뀨');
		pCenter.add(tfPass);
		tfPass.getDocument().addDocumentListener(listener);
		
		btnNewID = new JButton("회원가입");
		btnNewID.addActionListener(this);
		btnNewID.setBackground(Color.WHITE);
		pCenter.add(btnNewID);

		btnRogin = new JButton("로그인");
		btnRogin.addActionListener(this);
		btnRogin.setBackground(Color.WHITE);
		btnRogin.setEnabled(false);
		pCenter.add(btnRogin);
	}
	
	public ID getItem(){
		String id = tfID.getText();
		String pass = String.valueOf(tfPass.getPassword());
		
		return new ID(id, pass, null);
	}
	
	
	
	
	
	
	
	boolean idTrue;
	boolean passTrue;
	DocumentListener listener = new DocumentListener() {

		@Override
		public void removeUpdate(DocumentEvent e) {
			if (tfID.getText().equals("") || String.valueOf(tfPass.getPassword()).equals("")) {
				btnRogin.setEnabled(false);
			}

		}

		@Override
		public void insertUpdate(DocumentEvent e) {
			if (e.getDocument() == tfID.getDocument()) {
				idTrue = true;
			}
			if (e.getDocument() == tfPass.getDocument()) {
				passTrue = true;
			}
			if (idTrue && passTrue) {
				btnRogin.setEnabled(true);
			}

		}

		@Override
		public void changedUpdate(DocumentEvent e) {

		}
	};
	

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewID) {
			do_btnNewID_actionPerformed(e);
		}
		
		if (e.getSource() == btnRogin) {
			do_btnRogin_actionPerformed(e);
		}
	}

	protected void do_btnRogin_actionPerformed(ActionEvent e) {
		
		
		boolean rogin = service.selectId(getItem());
		if(rogin) {
			SearchFrame frame = new SearchFrame();
			frame.setVisible(true);
			setVisible(false);
		}else{
			JOptionPane.showMessageDialog(null, "아이디 및 비밀번호가 일치하지 않습니다.");
		}
		
	}

	
	NewIDFrame frame = new NewIDFrame();
	protected void do_btnNewID_actionPerformed(ActionEvent e) {
		frame.setService(service);
		frame.setVisible(true);
	}
}
