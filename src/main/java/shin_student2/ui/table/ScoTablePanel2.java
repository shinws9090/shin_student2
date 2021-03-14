package shin_student2.ui.table;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import shin_student2.dto.Student;

public class ScoTablePanel2 extends JPanel {
	private JTable table;

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	/**
	 * Create the panel.
	 */
	public ScoTablePanel2() {

		initialize();
	}

	private void initialize() {
		setBorder(new TitledBorder(new EmptyBorder(10, 10, 10, 10), "\uC131\uC801\uC870\uD68C", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		table.setModel(getModel());
		scrollPane.setViewportView(table);
	}

	private DefaultTableModel getModel() {
		return new DefaultTableModel(getData(), getColumnNames());
	}

	private String[] getColumnNames() {
		return new String[] { "학과", "이름", "학번", "1과목", "2과목", "3과목", "총점", "평균", "평어", "평점" };
	}

	private Object[][] getData() {
		return new Object[][] {};
	}

	public void setList(List<Student> s) {
		Object[][] data = new Object[s.size()][];
		for (int i = 0; i < data.length; i++) {
			data[i] = toArray(s.get(i));
		}
		CustomTableModel model = new CustomTableModel(data, getColumnNames());
		table.setModel(model);

		// 컬럼 내용 정렬
		setTableCellAlign(SwingConstants.CENTER, 0, 1);
		setTableCellAlign(SwingConstants.RIGHT, 2, 3, 4, 5, 6);
		// 컬럼별 간격 조정
//				setTableCellWidth(100,100,80,80,80,80,100); 10개

		// 조건별 행 색깔 변경
		setTableCellcondition(0, 1, 2, 3, 4, 5, 6,7,8,9);

	}

	private Object[] toArray(Student s) {
		return new Object[] { s.getDeptno().getDeptname(),
				s.getName(), s.getNo(),
				s.getScores().get(0).getScoer(),
				s.getScores().get(1).getScoer(), 
				s.getScores().get(2).getScoer(), 
				s.getTotal(), s.getAvg(),
				s.getRank(), s.getRanksco() };
	}

	public void setTableCellcondition(int... idx) {
		TableColumnModel tcm = table.getColumnModel();
		ConditionTableCellRenderer ctcr = new ConditionTableCellRenderer();
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

	// 테이블 클릭 못하게하는 내부 클래스 생성
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
	class ConditionTableCellRenderer extends JLabel implements TableCellRenderer{

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			setText(value==null?"":value.toString());
			setOpaque(true);
			String rank = (String)table.getValueAt(row, 8);
			if(rank.equals("F")) {
				setBackground(Color.RED);
			}else {
				setBackground(Color.WHITE);
			}
			return this;
		}
		
	}
}
