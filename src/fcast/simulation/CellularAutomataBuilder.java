package fcast.simulation;

import fcast.gui.WorldGui;
import fcast.universe.world.cell.CellType;
import fcast.universe.world.cell.StateList;
import javafx.scene.chart.NumberAxis;

/**
 * Classe astratta per definire il "builder" di ogni simulazione
 *
 * @param <T>
 *            tipo di cella presente nella simulazione
 */
public abstract class CellularAutomataBuilder<T extends CellType> {
	/**
	 * Creazione del populationChart
	 * 
	 * @param list
	 *            lista degli stati della simulazione
	 * @return grafico della popolazione
	 */
	public final PopulationChart<T> buildPopulationChart(StateList<T> list) {
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

	/**
	 * Creazione dell'EvolutionChart
	 * 
	 * @return grafico della velocità di evoluzione
	 */
	public final EvolutionRateChart<T> buildEvolutionRateChart() {
		return new EvolutionRateChart<T>();
	}

	/**
	 * Metodo per la creazione del mondo grafico
	 * 
	 * @return mondo grafico della simulazione
	 */
	public abstract WorldGui<?> build();
}
