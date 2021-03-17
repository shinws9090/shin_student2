package shin_student2.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import shin_student2.ui.scoPanel.ScoPanel;
import shin_student2.ui.stdPanel.StdPanel;

public class SearchFrame extends JFrame {

	private JPanel contentPane;
	private StdPanel pStdManag;
	private ScoPanel pScoManag;
	

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

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setEnabled(true);
		contentPane.add(tabbedPane, BorderLayout.CENTER);

		pStdManag = new StdPanel();
		pStdManag.setBorder(new EmptyBorder(10, 10, 10, 10));
		tabbedPane.addTab("학생 관리", null, pStdManag, null);
		pStdManag.setLayout(new GridLayout(0, 2, 10, 0));
		
		pScoManag = new ScoPanel();
		tabbedPane.addTab("성적 관리", null, pScoManag, null);
	}
	



	

	

	
}
