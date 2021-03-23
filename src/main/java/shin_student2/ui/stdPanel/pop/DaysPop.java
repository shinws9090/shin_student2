package shin_student2.ui.stdPanel.pop;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import shin_student2.dto.Days;
import shin_student2.dto.Department;
import shin_student2.ui.stdPanel.pop.manag.DaysManag;
import shin_student2.ui.stdPanel.pop.manag.SuperManagPanel;
import shin_student2.ui.table.DaysTable;
import shin_student2.ui.table.SuperTable;

public class DaysPop extends SuperPop<Days> {
	public DaysPop() {
	}

	@Override
	protected SuperManagPanel<Days> createManag() {
		return new DaysManag();
	}

	@Override
	protected SuperTable<Days> createTable() {
		return new DaysTable();
	}

	@Override
	protected void do_button_actionPerformed(ActionEvent e) {
		Days days = pConfirm.getItem();
		int res = managService.insertDays(days);
		pTable.loadData("");
		search.loadComboBox();
		pConfirm.clearTf();
		if(res==0) {
			JOptionPane.showMessageDialog(null, "추가가 안됬는디용");
		}else {
			JOptionPane.showMessageDialog(null, "추가 OK");
		}
	}
	@Override
	protected void do_btnUpdate_actionPerformed(ActionEvent e) {
		Days days = pConfirm.getItem();
		int res = managService.updateDays(days);
		System.out.println(res);
		pTable.loadData("");
		search.loadComboBox();
		pConfirm.clearTf();
		if(res==0) {
			JOptionPane.showMessageDialog(null, "수정이 안됬는디용");
		}else {
			JOptionPane.showMessageDialog(null, "수정 OK");
		}
	}
	@Override
	protected void do_btnDelete_actionPerformed(ActionEvent e) {
		Days days = pConfirm.getItem();
		int res = managService.deleteDays(days);
		pTable.loadData("");
		search.loadComboBox();
		pConfirm.clearTf();
		if(res==0) {
			JOptionPane.showMessageDialog(null, "삭제가 안됬는디용");
		}else {
			JOptionPane.showMessageDialog(null, "삭제 OK");
		}
	}

}
