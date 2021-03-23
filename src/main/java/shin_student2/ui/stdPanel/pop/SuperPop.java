package shin_student2.ui.stdPanel.pop;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import shin_student2.service.ManagService;
import shin_student2.ui.stdPanel.StdLHSearchPanel;
import shin_student2.ui.stdPanel.pop.manag.DeptManag;
import shin_student2.ui.stdPanel.pop.manag.SuperManagPanel;
import shin_student2.ui.table.DepartmentTable;
import shin_student2.ui.table.SuperTable;

@SuppressWarnings("serial")
public abstract class SuperPop<T> extends JPanel implements ActionListener {
	private JButton button;
	private JButton btnUpdate;
	private JButton btnDelete;
	protected SuperTable<T> pTable;
	protected SuperManagPanel<T> pConfirm;
	protected ManagService managService;
	StdLHSearchPanel search;

	public void setSearch(StdLHSearchPanel search) {
		this.search = search;
	}

	/**
	 * Create the panel.
	 */
	public SuperPop() {

		initialize();
	}

	private void initialize() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.WEST);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		pConfirm = createManag();
		panel.add(pConfirm);

		JPanel pBtns = new JPanel();
		panel.add(pBtns);

		button = new JButton("추가");
		button.addActionListener(this);
		pBtns.add(button);

		btnUpdate = new JButton("수정");
		btnUpdate.addActionListener(this);
		pBtns.add(btnUpdate);

		btnDelete = new JButton("삭제");
		btnDelete.addActionListener(this);
		pBtns.add(btnDelete);

		pTable = createTable();
		pTable.loadData("");
		panel.add(pTable);
		pTable.setpConfirm(pConfirm);
	}

	protected abstract SuperManagPanel<T> createManag();

	protected abstract SuperTable<T> createTable();

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnDelete) {
			do_btnDelete_actionPerformed(e);
		}
		if (e.getSource() == btnUpdate) {
			do_btnUpdate_actionPerformed(e);
		}
		if (e.getSource() == button) {
			do_button_actionPerformed(e);
		}
	}

	protected abstract void do_button_actionPerformed(ActionEvent e);

	protected abstract void do_btnUpdate_actionPerformed(ActionEvent e);

	protected abstract void do_btnDelete_actionPerformed(ActionEvent e);

	public void setManagService(ManagService managService) {
		this.managService = managService;
	}

}
