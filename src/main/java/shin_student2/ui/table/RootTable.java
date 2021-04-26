package shin_student2.ui.table;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;

import javax.swing.SwingConstants;

import shin_student2.dto.ID;
import shin_student2.service.IDService;
import shin_student2.ui.exception.NotSelectedException;

public class RootTable extends SuperTable<ID> {
	IDService service = new IDService();
	@Override
	public void actionPerformed(ActionEvent e) {
		ID id = getItem();
		if(id.isGrant()) {
			id.setGrant(false);
		}else {
			id.setGrant(true);
		}
		service.updateID(id);
		loadData("");
	}

	@Override
	protected void initList(String where) {
		list = service.selectIdAll();
		delete.setVisible(false);
		update.setText("권한 변경");
	}

	@Override
	public MouseAdapter tableMouseClicked() {
		return null;
	}

	@Override
	public Object[] getColumnNames() {
		return new String[] { "아이디", "로그인 권한" };
	}

	@Override
	public ID getItem() {
		int idx = table.getSelectedRow();
		if (idx == -1) {
			throw new NotSelectedException();
		}
		String no = (String) table.getValueAt(idx, 0);
		return list.get(list.indexOf(new ID(no)));
	}

	@Override
	protected void setTebleModelMode() {
		setTableCellAlign(SwingConstants.CENTER, 0,1);
	}

	@Override
	public Object[] toArray(ID t) {
		return new Object[] { t.getId(), t.isGrant()?"O":"X" };
	}

}
