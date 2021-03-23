package shin_student2.ui.stdPanel.pop;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import shin_student2.dto.Attendings;
import shin_student2.ui.stdPanel.StdLHSearchPanel;
import shin_student2.ui.stdPanel.pop.manag.AttendingsManag;
import shin_student2.ui.stdPanel.pop.manag.SuperManagPanel;
import shin_student2.ui.table.AttendingsTable;
import shin_student2.ui.table.SuperTable;

public class AttendingsPop extends SuperPop<Attendings> {
	

	@Override
	protected SuperManagPanel<Attendings> createManag() {
		return new AttendingsManag();
	}

	@Override
	protected SuperTable<Attendings> createTable() {
		return new AttendingsTable();
	}

	@Override
	protected void do_button_actionPerformed(ActionEvent e) {
		Attendings attendings = pConfirm.getItem();
		int res = managService.insertAtd(attendings);
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
		Attendings attendings = pConfirm.getItem();
		int res = managService.updateAtd(attendings);
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
		Attendings attendings = pConfirm.getItem();
		int res = managService.deleteAtd(attendings);
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
