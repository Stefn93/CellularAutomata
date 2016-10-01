package framework.simulation;

import java.util.List;

import controllerGUI.SimulationController;
import framework.gui.WorldGui;
import framework.universe.cell.Pattern;
import framework.universe.world.World;
import javafx.application.Platform;

/**
 * Thread della simulazione vera
 * @author Gianluca
 *
 * @param <CellType>
 */
public class SimulationThread<CellType> extends Thread {
	/**
	 * Mondo 
	 */
	protected World<CellType> world;
	protected SimulationController controller;
	protected WorldGui<CellType> gui;
	private int generation = 0;
	private int delay = 500;
	private boolean paused;
	private Monitor monitor;
	
	public SimulationThread(WorldGui<CellType> gui) {
		this.world = gui.getWorld();
		this.gui = gui;
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
						}
					});
					SimulationThread.sleep(delay);
					incrementGeneration();
					
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
	
	public World<CellType> getWorld() {
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
	
	public WorldGui<CellType> getGui() {
		return gui;
	}

	public void setGuiController(SimulationController controller) {
		this.controller = controller;
	}
}
