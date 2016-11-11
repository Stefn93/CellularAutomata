package sampleCA.samplepatterns;

import fcast.universe.world.bidimensional.GridPattern;
import sampleCA.SampleCellType;
import sampleCA.SampleStateList;

public class SamplePattern extends GridPattern<SampleCellType> {

	@Override
	public SampleCellType[][] get() {
		// Returns a single empty cell to be added directly to the simulation
		return new SampleCellType[][] { { new SampleStateList().get("empty") } };
	}

}
