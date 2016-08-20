package framework.simulation;

import framework.gui.CAGUI;
import framework.worldmodel.World2D;

public abstract class Simulation2DThread<CellType> extends SimulationThread<CellType>{
	
	protected Simulation2DThread(World2D<CellType> world, Behaviour<CellType> behaviour, CAGUI<CellType> gui){
		super(world, behaviour, gui);
	}
	

	
}
