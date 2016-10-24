package framework.simulation;

import java.io.IOException;
import java.util.List;

import controllerGUI.SimulationController;
import framework.gui.WorldGui;
import framework.universe.cell.CellType;
import framework.universe.cell.Pattern;
import framework.universe.world.World;
import javafx.application.Platform;

/**
 * Thread della simulazione
 * 
 * @author Gianluca
 *
 * @param <x>
 */
public class SimulationThread<x extends CellType> extends Thread {
	/**
	 * Mondo
	 */
	protected World<x> world;
	protected SimulationController controller;
	protected WorldGui<x> gui;
	protected CellularAutomatonChart populationChart;
	protected CellularAutomatonChart evolutionChart;
	private int generation = 0;
	private int delay = 50; // if delay goes under 100, the simulation may slow
							// down.
	private boolean paused;

	public SimulationThread(WorldGui<x> gui, CellularAutomatonChart populationChart, CellularAutomatonChart chart) {
		this.world = gui.getWorld();
		this.gui = gui;
		this.populationChart = populationChart;
		this.evolutionChart = chart;
	}

	protected void incrementGeneration() {
		gui.showWorld();
		generation++;
		world.nextState();
	}

	public int getGeneration() {
		return generation;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						if (!paused) {
							controller.getGenerationLabel().setText("Generation n�" + Integer.toString(generation));
							controller.setSimulationInfo(world.getInfo());
							populationChart.updateInfo(generation, world.getPopulationStatus());
							evolutionChart.updateInfo(generation, world.getEvolutionRate());
							incrementGeneration();
						}
					}
				});
				SimulationThread.sleep(delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void setDelay(int delay) {
		this.delay = delay;
	}

	public int getDelay() {
		return delay;
	}

	public World<x> getWorld() {
		return world;
	}

	public void switchPause() {
		if (paused == true)
			paused = false;
		else {
			paused = true;

		}
	}

	public void reset() {
		paused = false;
		generation = 0;
		world.reset();
		populationChart.reset();
		evolutionChart.reset();
	}

	public List<? extends Pattern> getPatterns() {
		return gui.getPatternList();
	}

	public WorldGui<x> getGui() {
		return gui;
	}

	public void setGuiController(SimulationController controller) {
		this.controller = controller;
	}

	public void save() {
		try {
			evolutionChart.save("EvolutionChartData.dat", "EvolutionChart.png");
			populationChart.save("PopulationChartData.dat", "PopulationChart.png");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
