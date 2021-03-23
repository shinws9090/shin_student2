package shin_student2.ui.table;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import shin_student2.dto.Days;
import shin_student2.dto.Department;
import shin_student2.ui.exception.NotSelectedException;

public class DaysTable extends SuperTable<Days> {

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	@Override
	protected void initList(String where) {
		List<Days> a = service.DaysComboBox();
		a.remove(0);
		list = a;
	}

	@Override
	public Object[] getColumnNames() {
		return new String[] { "주야코드", "주야이름" };
	}

	@Override
	protected void setTebleModelMode() {

	}

	@Override
	public Object[] toArray(Days s) {
		return new Object[] { s.getDayno(), s.getDay() };
	}

	@Override
	public Days getItem() {
		int idx = table.getSelectedRow();
		int no = (int) table.getValueAt(idx, 0);
		if (idx == -1) {
			throw new NotSelectedException();
		}
		return list.get(list.indexOf(new Days(no)));
	}

	@Override
	public MouseAdapter tableMouseClicked() {
		return new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				Days department = getItem();
				pConfirm.setItem(department);

			}

		};
	}

}
