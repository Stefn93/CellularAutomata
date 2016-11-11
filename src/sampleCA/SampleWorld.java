package sampleCA;

import java.util.Map;

import fcast.simulation.Behaviour;
import fcast.universe.world.bidimensional.World2D;
import fcast.universe.world.cell.Cell;

public class SampleWorld extends World2D<SampleCellType> {

	public SampleWorld(int height, int length, Behaviour<SampleCellType> behaviour) {
		super(new SampleStateList(), height, length, behaviour);
	}

	@Override
	public Map<SampleCellType, Integer> getPopulationStatus() {
		// Create a map association between an integer value and a cell of the
		// grid, in order to populate the graphs.
		return null;
	}

	@Override
	protected Cell<SampleCellType> createNewCell() {
		// This method may be used to return a particular type of cell.
		return null;
	}

	@Override
	protected void clear() {
		// Standard method used to reset the simulation.
	}

	@Override
	protected void defaultState() {
		// Standard method used to set the initial state of the simulation.
	}

}
