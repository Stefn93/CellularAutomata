package framework.simulation;

import framework.gui.WorldGui;
import framework.worldmodel.World2D;

public abstract class Simulation2DThread<CellType> extends SimulationThread<CellType>{
	
	protected Simulation2DThread(World2D<CellType> world, WorldGui<CellType> gui){
		super(world, gui);
	}
	
}
