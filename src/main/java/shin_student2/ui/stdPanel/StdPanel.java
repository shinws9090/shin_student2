package shin_student2.ui.stdPanel;

import javax.swing.JPanel;
import java.awt.GridLayout;
import shin_student2.ui.table.StdTablePanel;

public class StdPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public StdPanel() {

		initialize();
	}
	private void initialize() {
		setLayout(new GridLayout(0, 2, 0, 0));
		
		StdLHPanel panel = new StdLHPanel();
		add(panel);
		
		StdTablePanel panel_1 = new StdTablePanel();
		add(panel_1);
	}

}
