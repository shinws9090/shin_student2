package shin_student2.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnStart;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 216);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTitle = new JLabel("학생관리 프로그램");
		lblTitle.setForeground(SystemColor.window);
		lblTitle.setOpaque(true);
		lblTitle.setBackground(SystemColor.activeCaption);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("굴림", Font.BOLD, 30));
		contentPane.add(lblTitle, BorderLayout.NORTH);
		
		JPanel pCenter = new JPanel();
		pCenter.setBackground(SystemColor.window);
		pCenter.setBorder(new EmptyBorder(20, 50, 20, 50));
		contentPane.add(pCenter, BorderLayout.CENTER);
		
		btnStart = new JButton("START");
		btnStart.addActionListener(this);
		pCenter.setLayout(new BorderLayout(0, 0));
		btnStart.setBackground(new Color(255, 250, 250));
		pCenter.add(btnStart);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnStart) {
			btnNewButton_1ActionPerformed(e);
		}
	}
	protected void btnNewButton_1ActionPerformed(ActionEvent e) {
		Search frame = new Search();
		frame.setVisible(true);
		setVisible(false);
	}
}
