package shin_student2.ui.table;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import shin_student2.dto.Department;
import shin_student2.dto.Militarys;
import shin_student2.ui.exception.NotSelectedException;

public class MilitarysTable extends SuperTable<Militarys> {

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	@Override
	protected void initList(String where) {
		List<Militarys> a = service.MiltComboBox();
		a.remove(0);
		list = a;
	}

	@Override
	public Object[] getColumnNames() {
		return new String[] { "병역코드", "병역구분" };
	}

	@Override
	protected void setTebleModelMode() {

	}

	@Override
	public Object[] toArray(Militarys s) {
		return new Object[] { s.getMiltno(), s.getMilitary() };
	}

	@Override
	public Militarys getItem() {
		int idx = table.getSelectedRow();
		if (idx == -1) {
			throw new NotSelectedException();
		}
		String no = (String) table.getValueAt(idx, 0);
		return list.get(list.indexOf(new Militarys(no)));
	}

	@Override
	public MouseAdapter tableMouseClicked() {
		return new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				Militarys department = getItem();
				pConfirm.setItem(department);

			}

		};
	}

}
