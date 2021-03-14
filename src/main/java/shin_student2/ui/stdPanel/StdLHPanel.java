package shin_student2.ui.stdPanel;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import shin_student2.dto.Attendings;
import shin_student2.dto.Days;
import shin_student2.dto.Department;
import shin_student2.dto.Militarys;
import shin_student2.dto.Student;
import shin_student2.ui.stdManag;
import shin_student2.ui.table.StdTablePanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class StdLHPanel extends JPanel implements ActionListener {
	private JTextField tfName;
	private JTextField tfStdNo;
	private JButton btnAcc;
	private StdLHSearchPanel pCenter;
	private JButton btnSearch;
	private JButton btnInsert;
	private JButton btnDelete;
	private stdManag frame;

	public JTextField getTfName() {
		return tfName;
	}

	public JTextField getTfStdNo() {
		return tfStdNo;
	}

	public JButton getBtnAcc() {
		return btnAcc;
	}

	public StdLHSearchPanel getpCenter() {
		return pCenter;
	}

	public JButton getBtnSearch() {
		return btnSearch;
	}

	public JButton getBtnInsert() {
		return btnInsert;
	}

	public JButton getBtnDelete() {
		return btnDelete;
	}

	/**
	 * Create the panel.
	 */
	public StdLHPanel() {
		setBorder(
				new TitledBorder(null, "\uD559\uC0DD\uC870\uD68C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setBounds(100, 100, 263, 690);
		setLayout(new BorderLayout(0, 0));

		JPanel pNorth = new JPanel();
		pNorth.setBorder(new EmptyBorder(10, 10, 10, 10));
		add(pNorth, BorderLayout.NORTH);
		pNorth.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel pTop = new JPanel();
		pNorth.add(pTop);
		pTop.setLayout(new GridLayout(0, 3, 10, 10));

		JLabel lblName = new JLabel("성      명");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		pTop.add(lblName);

		tfName = new JTextField();
		tfName.setHorizontalAlignment(SwingConstants.RIGHT);
		pTop.add(tfName);
		tfName.setColumns(10);

		JPanel panel_5 = new JPanel();
		pTop.add(panel_5);

		JLabel lblStdNo = new JLabel("학      번");
		lblStdNo.setHorizontalAlignment(SwingConstants.CENTER);
		pTop.add(lblStdNo);

		tfStdNo = new JTextField();
		tfStdNo.setHorizontalAlignment(SwingConstants.RIGHT);
		tfStdNo.setColumns(10);
		pTop.add(tfStdNo);

		btnSearch = new JButton("검색");
		pTop.add(btnSearch);

		JPanel pBottom = new JPanel();
		pBottom.setBorder(new EmptyBorder(30, 20, 0, 20));
		pNorth.add(pBottom);
		pBottom.setLayout(new GridLayout(0, 1, 0, 0));

		btnAcc = new JButton("상새조회▼");
		btnAcc.addActionListener(this);
		pBottom.add(btnAcc);

		pCenter = new StdLHSearchPanel();
		pCenter.setVisible(false);
		add(pCenter, BorderLayout.CENTER);

		JPanel pSouth = new JPanel();
		pSouth.setBorder(new EmptyBorder(10, 30, 10, 30));
		add(pSouth, BorderLayout.SOUTH);
		pSouth.setLayout(new GridLayout(0, 2, 0, 0));

		btnInsert = new JButton("추가");
		btnInsert.addActionListener(this);
		pSouth.add(btnInsert);

		btnDelete = new JButton("취소");
		btnDelete.addActionListener(this);
		pSouth.add(btnDelete);
		
		frame = new stdManag();
	}

	public Student getStudent() {

		Student std = pCenter.getStudent();

		if (std instanceof Student) {
			std.setName(tfName.getText());
			try {
				std.setNo(Integer.parseInt(tfStdNo.getText()));
			} catch (Exception e) {

			}

		} else {
			if ((tfName.getText() + tfStdNo.getText()).equals("")) {
				return null;
			} else {
				std = new Student();
				std.setName(tfName.getText());
				try {
					std.setNo(Integer.parseInt(tfStdNo.getText()));
				} catch (Exception e) {

				}
			}
		}

		return std;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnDelete) {
			do_btnDelete_actionPerformed(e);
		}
		if (e.getSource() == btnInsert) {
			do_btnInsert_actionPerformed(e);
		}
		if (e.getSource() == btnAcc) {
			btnAcc_1ActionPerformed(e);
		}
	}

	protected void btnAcc_1ActionPerformed(ActionEvent e) {
		if (pCenter.isVisible()) {
			pCenter.setVisible(false);
			pCenter.clear();
			btnAcc.setText("상새조회▼");
		} else {
			pCenter.setVisible(true);
			btnAcc.setText("상새조회▲");

		}
	}
	protected void do_btnInsert_actionPerformed(ActionEvent e) {
		frame.setVisible(true);
		frame.getBtnInsetAndUpdate().setText("추가");
	}
	protected void do_btnDelete_actionPerformed(ActionEvent e) {
	}

	public void UPTable(StdTablePanel pStdTable) {
		frame.UPTable(pStdTable);
		
	}
}
