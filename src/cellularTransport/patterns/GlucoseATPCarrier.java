package cellularTransport.patterns;

import cellularTransport.CTCellType;
import cellularTransport.CTStateList;
import fcast.universe.world.bidimensional.GridPattern;

public class GlucoseATPCarrier extends GridPattern<CTCellType> {

	@Override
	public CTCellType[][] get() {
		return new CTCellType[][] {{new CTStateList().get("Glucose Uniporter")}, {new CTStateList().get("Glucose Uniporter")}};
	}
	
}
