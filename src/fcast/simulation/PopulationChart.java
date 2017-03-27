package fcast.simulation;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import fcast.universe.world.cell.CellType;
import fcast.universe.world.cell.StateList;
import javafx.scene.Node;
import javafx.scene.chart.Axis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;

/**
 * Grafico della popolazione di una simulazione
 *
 * @param <T>
 *            tipo di cella presente nella simulazione
 */
public class PopulationChart<T extends CellType> extends SimulationChart<T> {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PopulationChart(Axis xAxis, Axis yAxis, StateList<T> states) {
		super(xAxis, yAxis, states);

		XYChart.Series series;
		String colorString;
		Set<Node> lineNode;
		for (CellType state : states) {
			if (!state.getValueName().equals(StateList.DEAD)) {
				series = new XYChart.Series();
				colorString = state.getColor().toString().replace("0x", "");
				series.setName(state.getValueName());
				getData().add(series);
				series.getNode().getStyleClass().add(series.getName().replace(" ", "_"));
				lineNode = this.lookupAll("." + series.getName().replace(" ", "_"));
				for (final Node line : lineNode) {
					line.setStyle("-fx-stroke: #" + colorString + "; " + "-fx-stroke-width: 1.5px;");
				}

			}
		}
		Label l;
		Circle rectangle;
		Set<Node> set;
		for (CellType state : states) {
			set = this.lookupAll("Label.chart-legend-item.");
			for (Node n : set) {
				l = (Label) n;
				if (l.getText().equals(state.getValueName())) {
					rectangle = new Circle(10, state.getColor());
					l.setGraphic(rectangle);
				}
			}
		}
	}

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void updateInfo(int generation, Object o) {
		Map<T, Integer> worldStatus = (Map<T, Integer>) o;
		Iterator<XYChart.Series<Integer, Integer>> it = this.getDisplayedSeriesIterator();
		Series actual;
		while (it.hasNext()) {
			actual = it.next();
			for (CellType value : states) {
				if (actual.getName().equals(value.getValueName())) {
					actual.getData().add(new XYChart.Data(generation, worldStatus.get(value)));
				}
			}
		}

	}

}