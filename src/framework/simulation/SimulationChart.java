package framework.simulation;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.imageio.ImageIO;

import framework.universe.world.cell.CellType;
import framework.universe.world.cell.StateList;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.SnapshotParameters;
import javafx.scene.chart.Axis;
import javafx.scene.chart.LineChart;

public abstract class SimulationChart<T extends CellType> extends LineChart<Integer, Integer>
		implements CellularAutomatonChart {

	protected StateList<T> states;

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
		int max, min;
		for (Series s : this.getData()) {
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			printout.println(s.getName() + " :\n");
			int sum = 0;
			double avg = 0;
			int gen = 1;
			ObservableList<Data<Integer, Integer>> esempi = s.getData();
			for (Data<Integer, Integer> d : esempi) {
				int y = d.getYValue();
				sum += y;
				if (y > max)
					max = y;
				if (y < min)
					min = y;
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
