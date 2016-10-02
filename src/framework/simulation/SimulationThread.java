package framework.simulation;

import java.util.List;

import controllerGUI.SimulationController;
import framework.gui.WorldGui;
import framework.universe.cell.CellType;
import framework.universe.cell.Pattern;
import framework.universe.world.World;
import javafx.application.Platform;
import javafx.scene.chart.PieChart;

/**
 * Thread della simulazione vera
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
	protected PopulationChart<x> chart;
	private int generation = 0;
	private int delay = 5000;
	private boolean paused;
	
	public SimulationThread(WorldGui<x> gui, PopulationChart<x> chart2) {
		this.world = gui.getWorld();
		this.gui = gui;
		this.chart = chart2;
	}
	
	protected void incrementGeneration(){
		gui.showWorld();
		generation++;
		world.nextState();
	}
	
	public int getGeneration() {
		return generation;
	}

	
	public void run() {
		//gui.showWorld(world);
		while(true) {
			try {
				if (!paused) {
					Platform.runLater(new Runnable() {
						public void run() {
							controller.getGenerationLabel().setText("Generation n°" + Integer.toString(generation));
							incrementGeneration();
							chart.updateInfo(world.getPopulationStatus());

						}
					});
					SimulationThread.sleep(delay);

					
				}
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

	public boolean isPaused() {
		return paused;
	}

	public void setPaused(boolean paused) {
		this.paused = paused;
	}

	
	public void reset() {
		paused = false;
		generation = 0;
		world.reset();
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
}
