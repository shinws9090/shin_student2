package shin_student2.ui.scoPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DatasetRenderingOrder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.Values;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.TextAnchor;

import shin_student2.dto.Student;

public class ScoChart extends JPanel implements ActionListener {

	private List<Student> list;
	private JButton btnChart;
	private JComboBox<String> cbChart;
	private ChartPanel chartPanel;
	private JPanel panel_1;

	public ChartPanel getChartPanel() {
		return chartPanel;
	}

	public void setChartPanel(ChartPanel chartPanel) {
		this.chartPanel = chartPanel;
	}

	public ScoChart() {

		initialize();
	}

	private void initialize() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		String[] arr = { "학과별", "과목별" };
		cbChart = new JComboBox(arr);
		panel.add(cbChart);

		btnChart = new JButton("차트변경");
		btnChart.addActionListener(this);
		panel.add(btnChart);

		panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);

		JFreeChart chart = getChart(null);

		chartPanel = new ChartPanel(chart);

		panel_1.add(chartPanel);

	}

	public JFreeChart getChart(List<Values> values) {

		// 데이터 생성

//		DefaultCategoryDataset dataset1 = new DefaultCategoryDataset(); // bar chart 1
//
//		// 데이터 입력 ( 값, 범례, 카테고리 )
//
		// 그래프 1
		DefaultCategoryDataset dataset1 = new DefaultCategoryDataset(); // bar chart 1

		if (values != null) {
			for (Values a : values) {
				dataset1.addValue(a.getAvg(), a.getA(), a.getB());
			}
		}

		final BarRenderer renderer = new BarRenderer();

		// 공통 옵션 정의

		final CategoryItemLabelGenerator generator = new StandardCategoryItemLabelGenerator();

		final ItemLabelPosition p_center = new ItemLabelPosition(

				ItemLabelAnchor.CENTER, TextAnchor.CENTER

		);

		final ItemLabelPosition p_below = new ItemLabelPosition(

				ItemLabelAnchor.OUTSIDE6, TextAnchor.TOP_LEFT

		);

		Font f = new Font("Gulim", Font.BOLD, 14);

		Font axisF = new Font("Gulim", Font.PLAIN, 14);

		// 렌더링 세팅

		// 그래프 1

		renderer.setBaseItemLabelGenerator(generator);

		renderer.setBaseItemLabelsVisible(true);

		renderer.setBasePositiveItemLabelPosition(p_center);

		renderer.setBaseItemLabelFont(f);

//        renderer.setGradientPaintTransformer(new StandardGradientPaintTransformer(

//                GradientPaintTransformType.VERTICAL));

//        renderer.setSeriesPaint(0, new GradientPaint(1.0f, 1.0f, Color.white, 0.0f, 0.0f, Color.blue));

		renderer.setSeriesPaint(0, new Color(0, 162, 255));

		// plot 생성

		final CategoryPlot plot = new CategoryPlot();

		// plot 에 데이터 적재

		plot.setDataset(dataset1);

		plot.setRenderer(renderer);

		// plot 기본 설정

		plot.setOrientation(PlotOrientation.VERTICAL); // 그래프 표시 방향

		plot.setRangeGridlinesVisible(true); // X축 가이드 라인 표시여부

		plot.setDomainGridlinesVisible(true); // Y축 가이드 라인 표시여부

		// 렌더링 순서 정의 : dataset 등록 순서대로 렌더링 ( 즉, 먼저 등록한게 아래로 깔림 )

		plot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);

		// X축 세팅

		plot.setDomainAxis(new CategoryAxis()); // X축 종류 설정

		plot.getDomainAxis().setTickLabelFont(axisF); // X축 눈금라벨 폰트 조정

		plot.getDomainAxis().setCategoryLabelPositions(CategoryLabelPositions.STANDARD); // 카테고리 라벨 위치 조정

		// Y축 세팅

		plot.setRangeAxis(new NumberAxis()); // Y축 종류 설정

		plot.getRangeAxis().setTickLabelFont(axisF); // Y축 눈금라벨 폰트 조정

		// 세팅된 plot을 바탕으로 chart 생성

		final JFreeChart chart = new JFreeChart(plot);

//        chart.setTitle("Overlaid Bar Chart"); // 차트 타이틀

//        TextTitle copyright = new TextTitle("JFreeChart WaferMapPlot", new Font("SansSerif", Font.PLAIN, 9));

//        copyright.setHorizontalAlignment(HorizontalAlignment.RIGHT);

//        chart.addSubtitle(copyright);  // 차트 서브 타이틀

		return chart;

	}

	public void setList(List<Student> list) {
		this.list = list;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnChart) {
			if (cbChart.getSelectedItem().equals("학과별")) {
				do_btnChart_actionPerformedSUB(e);
			} else {
				do_btnChart_actionPerformedSCO(e);
			}
		}
	}

	protected void do_btnChart_actionPerformedSUB(ActionEvent e) {
		JFreeChart chart = getchart2();

		chartPanel.setChart(chart);
	}

	protected void do_btnChart_actionPerformedSCO(ActionEvent e) {
		System.out.println(list);
		JFreeChart chart = getchart3();

		chartPanel.setChart(chart);

	}

	public JFreeChart getchart2() {
		Values value1 = new Values();
		Values value2 = new Values();
		Values value3 = new Values();
		for (Student a : list) {
			if (a.getDeptno().getDeptno() == 1) {
				System.out.println(list);
				value1.getValue().add(a.getAvg());
				value1.setA("T1");
				value1.setB(a.getDeptno().getDeptname());
			} else if (a.getDeptno().getDeptno() == 2) {
				value2.getValue().add(a.getAvg());
				value2.setA("T1");
				value2.setB(a.getDeptno().getDeptname());
			} else if (a.getDeptno().getDeptno() == 3) {
				value3.getValue().add(a.getAvg());
				value3.setA("T1");
				value3.setB(a.getDeptno().getDeptname());
			}
		}
		List<Values> list = new ArrayList<Values>();
		list.add(value1);
		list.add(value2);
		list.add(value3);
		System.out.println(list);
		JFreeChart chart = getChart(list);
		return chart;
	}

	public JFreeChart getchart3() {
		System.out.println(list);
		Values value1 = new Values();
		Values value2 = new Values();
		Values value3 = new Values();
		Values value4 = new Values();
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.get(i).getScores().size(); j++) {
				if (list.get(i).getScores().get(j).getSubject().getSubNo() == 1) {
					value1.getValue().add((double) list.get(i).getScores().get(j).getScoer());
					value1.setA("S2");
					value1.setB(list.get(i).getScores().get(j).getSubject().getSubName());
				} else if (list.get(i).getScores().get(j).getSubject().getSubNo() == 2) {
					value2.getValue().add((double) list.get(i).getScores().get(j).getScoer());
					value2.setA("S2");
					value2.setB(list.get(i).getScores().get(j).getSubject().getSubName());
				} else if (list.get(i).getScores().get(j).getSubject().getSubNo() == 3) {
					value3.getValue().add((double) list.get(i).getScores().get(j).getScoer());
					value3.setA("S2");
					value3.setB(list.get(i).getScores().get(j).getSubject().getSubName());
				} else if (list.get(i).getScores().get(j).getSubject().getSubNo() == 4) {
					value4.getValue().add((double) list.get(i).getScores().get(j).getScoer());
					value4.setA("S2");
					value4.setB(list.get(i).getScores().get(j).getSubject().getSubName());
				}
			}
		}
		List<Values> list = new ArrayList<Values>();
		list.add(value1);
		list.add(value2);
		list.add(value3);
		list.add(value4);
		System.out.println(list);
		JFreeChart chart = getChart(list);
		return chart;
	}

	class Values {
		List<Double> value = new ArrayList<Double>();
		String a;
		String b;

		public Values() {
			super();
		}

		public Values(List<Double> value, String a, String b) {
			super();
			this.value = value;
			this.a = a;
			this.b = b;
		}

		public double getAvg() {
			int idx = 0;
			int total = 0;
			for (int i = 0; i < value.size(); i++) {
				idx += 1;
				total += value.get(i);
			}
			double avg = total / idx;

			return avg;
		}

		public List<Double> getValue() {
			return value;
		}

		public void setValue(List<Double> value) {
			this.value = value;
		}

		public String getA() {
			return a;
		}

		public void setA(String a) {
			this.a = a;
		}

		public String getB() {
			return b;
		}

		public void setB(String b) {
			this.b = b;
		}

		@Override
		public String toString() {
			return String.format("Values [value=%s, a=%s, b=%s]", value, a, b);
		}

	}

}
