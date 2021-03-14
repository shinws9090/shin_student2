package shin_student2.ui.table;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import shin_student2.dto.Student;
import shin_student2.ui.exception.NotSelectedException;

public abstract class SuperTable extends JPanel implements ActionListener{
	protected JTable table;
	protected List<Student> list;
	protected JMenuItem update;
	protected JMenuItem delete;
	
	
	public SuperTable() {

		initialize();
	}
	public void loadData(String where) {
		initList(where);
		setList();
	}
	
	protected abstract void initList(String where);
	
	private void initialize() {
		setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPopupMenu popup= new JPopupMenu();
		table.setComponentPopupMenu(popup);
		update = new JMenuItem("수정");
		update.addActionListener(this);
		delete = new JMenuItem("삭제");
		delete.addActionListener(this);
		popup.add(update);
		popup.add(delete);
	}


	public abstract String[] getColumnNames();
	
	public Student getItem() {
		int idx = table.getSelectedRow();
		if(idx == -1) {
			throw new NotSelectedException();
		}
		return list.get(idx);
	}
	
	public void setList() {
		Object[][] data = null;
		if (list instanceof List) {
			data = new Object[list.size()][];
			for (int i = 0; i < data.length; i++) {
				data[i] = toArray(list.get(i));
			}
		} else {
			data = new Object[0][];
		}
		CustomTableModel model = new CustomTableModel(data, getColumnNames());
		table.setModel(model);

		setTebleModelMode();
//		// 컬럼 내용 정렬
//		setTableCellAlign(SwingConstants.CENTER, 0, 1);
//		setTableCellAlign(SwingConstants.RIGHT, 2, 3, 4, 5, 6);
//		// 컬럼별 간격 조정
////				setTableCellWidth(100,100,80,80,80,80,100); 10개
//
//		// 조건별 행 색깔 변경
//		setTableCellcondition(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

	}

	protected abstract void setTebleModelMode();

	public abstract Object[] toArray(Student s);

	public void setTableCellcondition(int... idx) {
		TableColumnModel tcm = table.getColumnModel();
		ConditionTableCellRenderer ctcr = new ConditionTableCellRenderer();
		ctcr.setHorizontalAlignment(SwingConstants.CENTER); // 가운대 정렬
		for (int i = 0; i < idx.length; i++) {
			tcm.getColumn(idx[i]).setCellRenderer(ctcr);
		}
	}

	public void setTableCellWidth(int... width) {
		TableColumnModel tcm = table.getColumnModel();
		for (int i = 0; i < width.length; i++) {
			tcm.getColumn(i).setPreferredWidth(width[i]);
		}
	}

	public void setTableCellAlign(int align, int... idx) { // 가변배열?
		TableColumnModel tcm = table.getColumnModel();

		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align); // 가운대 정렬

		for (int i = 0; i < idx.length; i++) {
			tcm.getColumn(idx[i]).setCellRenderer(dtcr);
		}
	}

	class CustomTableModel extends DefaultTableModel {

		public CustomTableModel(Object[][] data, Object[] columnNames) {
			super(data, columnNames);
		}

		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	}

	@SuppressWarnings("serial")
	class ConditionTableCellRenderer extends JLabel implements TableCellRenderer {

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			setText(value == null ? "" : value.toString());
			setOpaque(true);
			String rank = (String) table.getValueAt(row, 8);
			if (rank.equals("F")) {
				setBackground(Color.RED);
			} else {
				setBackground(Color.WHITE);
			}
			return this;
		}

	}
}
