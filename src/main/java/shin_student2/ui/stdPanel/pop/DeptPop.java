package shin_student2.ui.stdPanel.pop;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.Provider.Service;

import javax.swing.JOptionPane;

import shin_student2.dto.Department;
import shin_student2.ui.stdPanel.pop.manag.DeptManag;
import shin_student2.ui.stdPanel.pop.manag.SuperManagPanel;
import shin_student2.ui.table.DepartmentTable;
import shin_student2.ui.table.SuperTable;

public class DeptPop extends SuperPop<Department>{
	

	@Override
	protected SuperManagPanel<Department> createManag() {
		return new DeptManag();
	}
	@Override
	protected SuperTable<Department> createTable() {
		return new DepartmentTable();
	}
	
	@Override
	protected void do_button_actionPerformed(ActionEvent e) {
		Department department = pConfirm.getItem();
		int res = managService.insertDept(department);
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
		Department department = pConfirm.getItem();
		int res = managService.updateDept(department);
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
		Department department = pConfirm.getItem();
		int res = managService.deleteDept(department);
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
