package shin_student2.ui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import shin_student2.dto.Student;
import shin_student2.service.StudentService;
import shin_student2.ui.exception.InvalidCheckException;
import shin_student2.ui.exception.SqlConstraintException;
import shin_student2.ui.stdPanel.StdManagPanel;
import shin_student2.ui.table.StdTablePanel;

public class stdManagFrame extends JFrame implements ActionListener {
	
	private String imgPath = System.getProperty("user.dir") + File.separator + "images" + File.separator;
	private JPanel contentPane;
	private JButton btnInsetAndUpdate;
	private StdManagPanel pCenter;
	private StudentService stdService = StudentService.getInstance();
	private StdTablePanel pStdTable;
	private Student student;
	private JButton btnClear;
	
	public JButton getBtnInsetAndUpdate() {
		return btnInsetAndUpdate;
	}
	public void setBtnInsetAndUpdate(JButton btnInsetAndUpdate) {
		this.btnInsetAndUpdate = btnInsetAndUpdate;
	}
	
	public stdManagFrame() {
		initialize();
	}
	private void initialize() {
		setTitle("학생 관리프로그램");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 454, 401);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pTitle = new JPanel();
		contentPane.add(pTitle, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("학생정보");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 25));
		pTitle.add(lblNewLabel);
		
		pCenter = new StdManagPanel();
		contentPane.add(pCenter, BorderLayout.CENTER);
		
		JPanel pBtn = new JPanel();
		contentPane.add(pBtn, BorderLayout.SOUTH);
		
		btnInsetAndUpdate = new JButton("");
		btnInsetAndUpdate.addActionListener(this);
		pBtn.add(btnInsetAndUpdate);
		
		btnClear = new JButton("취소");
		btnClear.addActionListener(this);
		pBtn.add(btnClear);
	}

	public void setvalue(Student std) {
		pCenter.setvalue(std);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnClear) {
			do_btnClear_actionPerformed(e);
		}
		try {
		if (e.getSource() == btnInsetAndUpdate) {
			if(e.getActionCommand().equals("추가")) {
				btnInset_actionPerformed(e);
			}
			if(e.getActionCommand().equals("저장")) {
				btnUpdate_actionPerformed(e);
			}
			
			byte[] data = Files.readAllBytes(pCenter.getChooserFile().toPath());
			
			FileOutputStream fos = new FileOutputStream(imgPath+student.getPic());
			
			fos.write(data);
		}
		}catch(SqlConstraintException | InvalidCheckException | IOException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}catch(NumberFormatException e1) {
			JOptionPane.showMessageDialog(null, "학번은 숫자로 입력바랍니다.");
			
		}
	}
	protected void btnInset_actionPerformed(ActionEvent e) {
		
		student = pCenter.getStudent();
		String res = stdService.addStudent(student);
		if(res.equals("commit")) {
			JOptionPane.showMessageDialog(null, "추가 완료");
			setVisible(false);
		}else {
			JOptionPane.showMessageDialog(null, "중복 및 빈칸이 있습니다.");
		}
		pStdTable.loadData("");
		
	}
	protected void btnUpdate_actionPerformed(ActionEvent e) {
		student = pCenter.getStudent();
		stdService.modifyStudent(student);
		JOptionPane.showMessageDialog(null, student+"수정완료");
		setVisible(false);
		pStdTable.loadData("");
	}
	public void setTable(StdTablePanel pStdTable) {
		
		this.pStdTable=pStdTable;
		
	}
	protected void do_btnClear_actionPerformed(ActionEvent e) {
		pCenter.clearValue();
	}
	
	public void clearValue() {
		pCenter.clearValue();
	}
}
