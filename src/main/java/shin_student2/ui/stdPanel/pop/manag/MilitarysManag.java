package shin_student2.ui.stdPanel.pop.manag;

import shin_student2.dto.Days;
import shin_student2.dto.Department;
import shin_student2.dto.Militarys;

public class MilitarysManag extends SuperManagPanel<Militarys> {

	@Override
	public String valueName() {
		return "병역구분";
	}

	@Override
	public String keyName() {
		return "병역코드";
	}

	@Override
	public String titleName() {
		return "병역관리";
	}

	@Override
	public void setItem(Militarys t) {
		tfKey.setText(t.getMiltno());
		tfValue.setText(t.getMilitary());
	}

	@Override
	public Militarys getItem() {
		String no = tfKey.getText();
		String name = tfValue.getText();
		return new Militarys(no, name);
	}

}
