package shin_student2.ui.table;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import shin_student2.dto.Department;
import shin_student2.ui.exception.NotSelectedException;
import shin_student2.ui.stdPanel.pop.manag.DeptManag;

public class DepartmentTable extends SuperTable<Department> {
	

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	@Override
	protected void initList(String where) {
		List<Department> a = service.DeptComboBox();
		a.remove(0);
		list = a;
	}

	@Override
	public Object[] getColumnNames() {
		return new String[] { "학과번호", "학과이름"};
	}

	@Override
	protected void setTebleModelMode() {

	}

	@Override
	public Object[] toArray(Department s) {
		return new Object[] { s.getDeptno(), s.getDeptname()};
	}

	@Override
	public Department getItem() {
		int idx = table.getSelectedRow();
		int no = (int) table.getValueAt(idx, 0);
		if(idx == -1) {
			throw new NotSelectedException();
		}
		return list.get(list.indexOf(new Department(no)));
	}

	@Override
	public MouseAdapter tableMouseClicked() {
		return new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				Department department = getItem();
				pConfirm.setItem(department);
				
			}
			
		};
	}

}
