package fcast.simulation;

import java.io.IOException;
import java.util.List;

import fcast.gui.WorldGui;
import fcast.gui.controller.SimulationController;
import fcast.universe.world.World;
import fcast.universe.world.cell.CellType;
import fcast.universe.world.cell.Pattern;
import javafx.application.Platform;

/**
 * Thread della simulazione
 * 
 * @author Gianluca
 *
 * @param <x>
 */
public class SimulationThread<x extends CellType> extends Thread {

	protected World<x> world;
	protected SimulationController controller;
	protected WorldGui<x> gui;
	protected CellularAutomatonChart populationChart;
	protected CellularAutomatonChart evolutionChart;
	private int generation = 0;
	private int delay = 50; // if delay goes under 100, the simulation may slow
							// down.
	private boolean paused;

	/**
	 * Costruttore del thread
	 * 
	 * @param gui
	 *            mondo grafico su cui si svolge la simulazione
	 * @param populationChart
	 *            grafico della popolazione
	 * @param chart
	 *            grafico della frequenza di evoluzione
	 */
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

	/**
	 * Getter per la generazione
	 * 
	 * @return generazione corrente
	 */
	public int getGeneration() {
		return generation;
	}

	@Override
	public void run() {
		try {
			while (true) {
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						if (!paused) {
							controller.getGenerationLabel().setText("Generation n°" + Integer.toString(generation));
							controller.setSimulationInfo(world.getInfo());
							populationChart.updateInfo(generation, world.getPopulationStatus());
							evolutionChart.updateInfo(generation, world.getEvolutionRate());
							incrementGeneration();
						}
					}
				});
				SimulationThread.sleep(delay);
			}
		} catch (InterruptedException e) {
		}
	}

	/**
	 * Setter per il delay
	 * 
	 * @param delay
	 *            nuovo delay
	 */
	public void setDelay(int delay) {
		this.delay = delay;
	}

	/**
	 * Getter per il delay
	 * 
	 * @return delay corrente
	 */
	public int getDelay() {
		return delay;
	}

	/**
	 * Getter per il mondo logico su cui si svolge la simulazione
	 * 
	 * @return mondo su cui si svolge la simulazione
	 */
	public World<x> getWorld() {
		return world;
	}

	/**
	 * Effettua lo switch del valore di pausa
	 */
	public void switchPause() {
		if (paused == true) {
			paused = false;
		} else {
			paused = true;
		}
	}

	/**
	 * Ripristina la simulazione
	 */
	public void reset() {
		controller.disableSave();
		paused = false;
		generation = 0;
		world.reset();
		populationChart.reset();
		evolutionChart.reset();
	}

	/**
	 * Restituisce la lista dei pattern della simulazione
	 */
	public List<? extends Pattern> getPatterns() {
		return gui.getPatternList();
	}

	/**
	 * Getter per il mondo grafico della simulazione
	 * 
	 * @return mondo grafico su cui si svolge la simulazione
	 */
	public WorldGui<x> getGui() {
		return gui;
	}

	/**
	 * Setter per il controller dell'interfaccia grafica
	 * 
	 * @param controller
	 */
	public void setGuiController(SimulationController controller) {
		this.controller = controller;
	}

	/**
	 * Metodo per il salvataggio dei dati della simulazione sui file relativi.
	 */
	public void save() {
		try {
			evolutionChart.save("EvolutionChartData.dat", "EvolutionChart.png");
			populationChart.save("PopulationChartData.dat", "PopulationChart.png");
		} catch (IOException e) {
		}
	}
}
