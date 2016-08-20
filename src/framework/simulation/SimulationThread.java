package framework.simulation;

import framework.gui.CAGUI;
import framework.worldmodel.World;

/**
 * Thread della simulazione vera
 * @author Gianluca
 *
 * @param <CellType>
 */
public abstract class SimulationThread<CellType> extends Thread {
	/**
	 * Mondo 
	 */
	protected World<CellType> world;
	protected Behaviour<CellType> behaviour;
	protected CAGUI<CellType> gui;
	
	
	public SimulationThread(World<CellType> world, Behaviour<CellType> behaviour, CAGUI<CellType> gui) {
		this.world = world;
		this.behaviour = behaviour;
		this.gui = gui;
	}
	
	protected void incrementGeneration(){
		world.setGeneration(world.getGeneration() + 1);
		world.nextState();
		
	}

	
	public abstract void start(Object startParam);
	
	public World<CellType> getWorld() {
		return world;
	}

}
