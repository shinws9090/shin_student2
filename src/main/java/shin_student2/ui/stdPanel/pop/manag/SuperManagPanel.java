package shin_student2.ui.stdPanel.pop.manag;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

public abstract class SuperManagPanel<T> extends JPanel {
	protected JTextField tfKey;
	protected JTextField tfValue;

	public SuperManagPanel() {

		initialize();
	}
	private void initialize() {
		setBorder(new TitledBorder(null, titleName(), TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(0, 2, 10, 10));
		
		JLabel lblKey = new JLabel(keyName());
		lblKey.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblKey);
		
		tfKey = new JTextField();
		add(tfKey);
		tfKey.setColumns(10);
		
		JLabel lblValue = new JLabel(valueName());
		lblValue.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblValue);
		
		tfValue = new JTextField();
		add(tfValue);
		tfValue.setColumns(10);
	}
	public abstract String valueName();
	
	public abstract String keyName();
	
	public abstract String titleName();
	
	public abstract void setItem(T t);
	
	public abstract T getItem();
	
	public void clearTf() {
		tfKey.setText("");
		tfValue.setText("");
		
	}
	

}
