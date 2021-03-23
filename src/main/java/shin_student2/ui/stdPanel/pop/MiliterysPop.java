package shin_student2.ui.stdPanel.pop;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import shin_student2.dto.Attendings;
import shin_student2.dto.Department;
import shin_student2.dto.Militarys;
import shin_student2.ui.stdPanel.pop.manag.AttendingsManag;
import shin_student2.ui.stdPanel.pop.manag.MilitarysManag;
import shin_student2.ui.stdPanel.pop.manag.SuperManagPanel;
import shin_student2.ui.table.AttendingsTable;
import shin_student2.ui.table.MilitarysTable;
import shin_student2.ui.table.SuperTable;

public class MiliterysPop extends SuperPop<Militarys> {

	@Override
	protected SuperManagPanel<Militarys> createManag() {
		return new MilitarysManag();
	}

	@Override
	protected SuperTable<Militarys> createTable() {
		return new MilitarysTable();
	}

	@Override
	protected void do_button_actionPerformed(ActionEvent e) {
		Militarys militarys = pConfirm.getItem();
		int res = managService.insertMilitays(militarys);
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
		Militarys militarys = pConfirm.getItem();
		int res = managService.updateMilitays(militarys);
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
		Militarys militarys = pConfirm.getItem();
		int res = managService.deleteMilitays(militarys);
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
