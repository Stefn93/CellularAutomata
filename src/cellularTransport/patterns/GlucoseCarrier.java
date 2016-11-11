package cellularTransport.patterns;

import cellularTransport.CTCellType;
import cellularTransport.CTStateList;
import fcast.universe.world.bidimensional.GridPattern;

public class GlucoseCarrier extends GridPattern<CTCellType>{

	@Override
	public CTCellType[][] get() {
		return new CTCellType[][] {{new CTStateList().get("Glucose Carrier")}, {new CTStateList().get("Glucose Carrier")}};
	}

}
