package shin_student2.ui.stdPanel.pop.manag;

import shin_student2.dto.Department;

public class DeptManag extends SuperManagPanel<Department> {

	@Override
	public String valueName() {
		return "학과";
	}

	@Override
	public String keyName() {
		return "학과코드";
	}

	@Override
	public String titleName() {
		return "학과관리";
	}

	@Override
	public void setItem(Department t) {
		tfKey.setText(t.getDeptno()+"");
		tfValue.setText(t.getDeptname());
	}

	@Override
	public Department getItem() {
		int deptno = Integer.parseInt(tfKey.getText());
		String deptname = tfValue.getText();
		return new Department(deptno, deptname);
	}

}
