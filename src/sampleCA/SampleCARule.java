package sampleCA;

import fcast.simulation.GeneralBehaviour;
import fcast.universe.world.World;
import fcast.universe.world.cell.Cell;
import fcast.universe.world.cell.Coordinates;
import fcast.universe.world.cell.SimpleCell;

public class SampleCARule extends GeneralBehaviour<SampleCellType> {

	private static SampleStateList stateList = new SampleStateList();
	SampleCellType sampleCell;
	SampleWorld world;
	
	protected SampleCARule() {
		//Sets the initial content of the simulation cells
		super(new SimpleCell<SampleCellType>(stateList.get("empty")));
	}

	@Override
	public SampleCellType calculateNewValue(World<SampleCellType> world, Coordinates coordinates) {
		//This is the main method of the CA. It contains the main behaviour of the CA and its rules.
		//If the behaviour is too complex (it shouldn't be), it's appropriate to create other private methods within this class.
		
		//The world has to be set here.
		this.world = (SampleWorld) world;
		
		return sampleCell;
	}

}
