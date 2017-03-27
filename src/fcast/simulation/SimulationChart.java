package fcast.simulation;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.imageio.ImageIO;

import fcast.universe.world.cell.CellType;
import fcast.universe.world.cell.StateList;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.SnapshotParameters;
import javafx.scene.chart.Axis;
import javafx.scene.chart.LineChart;

/**
 * Classe astratta che implementa alcuni metodi validi per ogni grafico
 *
 * @param <T>
 *            tipo di cella presente nella simulazione
 */
public abstract class SimulationChart<T extends CellType> extends LineChart<Integer, Integer>
		implements CellularAutomatonChart {

	/**
	 * Lista degli stati della simulazione
	 */
	protected StateList<T> states;

	/**
	 * Costruttore del grafico
	 * 
	 * @param xAxis
	 *            Asse delle ascisse
	 * @param yAxis
	 *            Asse delle ordinate
	 * @param states
	 *            Lista degli stati
	 */
	public SimulationChart(Axis xAxis, Axis yAxis, StateList<T> states) {
		super(xAxis, yAxis);
		this.states = states;
		xAxis.setAnimated(false);
		yAxis.setAnimated(false);
		this.setAnimated(false);
	}

	@Override
	public void save(String dataName, String imgName) throws IOException {
		PrintWriter printout = new PrintWriter(new BufferedWriter(new FileWriter(dataName)));
		int max;
		int min;
		int sum;
		int gen;
		double avg;
		int y;
		ObservableList<Data<Integer, Integer>> esempi;
		for (Series s : this.getData()) {
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			printout.println(s.getName() + " :\n");
			sum = 0;
			avg = 0;
			gen = 1;
			esempi = s.getData();
			for (Data<Integer, Integer> d : esempi) {
				y = d.getYValue();
				sum += y;
				if (y > max) {
					max = y;
				}
				if (y < min) {
					min = y;
				}
				gen = d.getXValue();
				printout.println("\t<generation>" + gen + "<.generation>" + " \t <population>" + y + "<.population>");
			}
			avg = sum / gen;
			printout.println("\t<max>" + max + "<.max>" + "\t<min>" + min + "<.min>" + "\t<avg>" + avg + "<.avg>");

		}
		printout.close();

		File imgFile = new File(imgName);
		ImageIO.write(SwingFXUtils.fromFXImage(snapshot(new SnapshotParameters(), null), null), "png", imgFile);
	}

	@Override
	@SuppressWarnings("unchecked")
	public void reset() {
		Iterator<javafx.scene.chart.XYChart.Series<Integer, Integer>> it = this.getDisplayedSeriesIterator();
		while (it.hasNext()) {
			it.next().getData().clear();
		}
	}
}
