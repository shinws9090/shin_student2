package shin_student2.ui.table;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import shin_student2.dto.Attendings;
import shin_student2.dto.Department;
import shin_student2.ui.exception.NotSelectedException;

public class AttendingsTable extends SuperTable<Attendings> {

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	@Override
	protected void initList(String where) {
		List<Attendings> a = service.AtdComboBox();
		a.remove(0);
		list = a;
	}

	@Override
	public Object[] getColumnNames() {
		return new String[] { "학적코드", "학적구분" };
	}

	@Override
	protected void setTebleModelMode() {

	}

	@Override
	public Object[] toArray(Attendings s) {
		return new Object[] { s.getAtdno(), s.getAttending() };
	}

	@Override
	public Attendings getItem() {
		int idx = table.getSelectedRow();
		String no = (String) table.getValueAt(idx, 0);
		if (idx == -1) {
			throw new NotSelectedException();
		}
		return list.get(list.indexOf(new Attendings(no)));
	}

	@Override
	public MouseAdapter tableMouseClicked() {
		return new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				Attendings department = getItem();
				pConfirm.setItem(department);

			}

		};
	}

}
