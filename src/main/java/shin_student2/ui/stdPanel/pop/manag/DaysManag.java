package shin_student2.ui.stdPanel.pop.manag;

import shin_student2.dto.Days;
import shin_student2.dto.Department;

public class DaysManag extends SuperManagPanel<Days> {

	@Override
	public String valueName() {
		return "주야구분";
	}

	@Override
	public String keyName() {
		return "주야코드";
	}

	@Override
	public String titleName() {
		return "주야관리";
	}

	@Override
	public void setItem(Days t) {
		tfKey.setText(t.getDayno()+"");
		tfValue.setText(t.getDay());
	}

	@Override
	public Days getItem() {
		int no = Integer.parseInt(tfKey.getText());
		String name = tfValue.getText();
		return new Days(no, name);
	}

}
