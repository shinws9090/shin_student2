package shin_student2.ui.stdPanel.pop.manag;

import shin_student2.dto.Attendings;
import shin_student2.dto.Days;
import shin_student2.dto.Department;
import shin_student2.dto.Militarys;

public class AttendingsManag extends SuperManagPanel<Attendings> {

	@Override
	public String valueName() {
		return "학적구분";
	}

	@Override
	public String keyName() {
		return "학적코드";
	}

	@Override
	public String titleName() {
		return "학적관리";
	}

	@Override
	public void setItem(Attendings t) {
		tfKey.setText(t.getAtdno());
		tfValue.setText(t.getAttending());
	}

	@Override
	public Attendings getItem() {
		String no = tfKey.getText();
		String name = tfValue.getText();
		return new Attendings(no, name);
	}

}
