package sampleCA;

import java.util.ArrayList;
import java.util.List;

import fcast.gui.GridGui;
import fcast.gui.WorldGui;
import fcast.simulation.CellularAutomataBuilder;
import fcast.universe.world.bidimensional.GridPattern;
import sampleCA.samplepatterns.SamplePattern;

public class SampleBuilder extends CellularAutomataBuilder<SampleCellType> {

	@Override
	public WorldGui<?> build() {
		// Section used to add some of the created patterns to the "pattern"
		// choicebox in the simulation interface
		List<GridPattern<SampleCellType>> list = new ArrayList<GridPattern<SampleCellType>>();
		list.add(new SamplePattern());

		// Grid Setting
		GridGui<SampleCellType> gui = new GridGui<SampleCellType>(70, new SampleWorld(70, 70, new SampleCARule()),
				list);
		gui.setMouseListener(new SamplePattern());
		return gui;
	}

}
