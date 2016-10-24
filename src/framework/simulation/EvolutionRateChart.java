package framework.simulation;

import java.util.Set;

import framework.universe.cell.CellType;
import javafx.scene.Node;
import javafx.scene.chart.Axis;
import javafx.scene.chart.XYChart;

public class EvolutionRateChart<T extends CellType> extends SimulationChart<T> {

	public EvolutionRateChart(Axis xAxis, Axis yAxis) {
		super(xAxis, yAxis, null);
		this.getXAxis().setLabel("Generation");
		this.getYAxis().setLabel("Evolution Rate");
		Series<Integer, Integer> rate = new Series<Integer, Integer>();
		rate.setName("Rate");
		getData().add(rate);
		rate.getNode().getStyleClass().add(rate.getName());
		Set<Node> lineNode = this.lookupAll("." + rate.getName());
		for (final Node line : lineNode) {
			line.setStyle("-fx-stroke-width: 1.5px;");
		}
	}

	@Override
	public void updateInfo(int generation, Object o) {
		int info = (Integer) o;
		this.getData().get(0).getData().add(new XYChart.Data(generation, info));

	}

}
