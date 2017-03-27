package fcast.simulation;

import fcast.gui.WorldGui;
import fcast.universe.world.cell.CellType;
import fcast.universe.world.cell.StateList;
import javafx.scene.chart.NumberAxis;

public abstract class CellularAutomataBuilder<T extends CellType> {
	public PopulationChart<T> buildPopulationChart(StateList<T> list) {
		final NumberAxis xAxis = new NumberAxis();
		final NumberAxis yAxis = new NumberAxis();
		xAxis.setAutoRanging(true);
		xAxis.setLabel("Generation");
		yAxis.setLabel("Population");
		xAxis.setAnimated(false);
		yAxis.setAnimated(false);

		// creating the chart
		final PopulationChart<T> chart = new PopulationChart<T>(xAxis, yAxis, list);

		return chart;
	}

	public EvolutionRateChart<T> buildEvolutionRateChart() {
		return new EvolutionRateChart<T>();
	}

	public abstract WorldGui<?> build();
}
