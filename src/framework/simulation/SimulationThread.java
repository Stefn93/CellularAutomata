package framework.simulation;

import framework.gui.WorldGui;
import framework.universe.world.World;

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
	protected WorldGui<CellType> gui;
	private int generation = 0;
	private int delay = 1500;
	private boolean paused;
	
	public SimulationThread(World<CellType> world, WorldGui<CellType> gui) {
		this.world = world;
		this.gui = gui;
	}
	
	protected void incrementGeneration(){
		generation++;
		world.nextState();
		gui.showWorld(world);
	}

	
	public void run() {
		gui.showWorld(world);
		while(!paused) {
			try {
				SimulationThread.sleep(delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			incrementGeneration();
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

}
