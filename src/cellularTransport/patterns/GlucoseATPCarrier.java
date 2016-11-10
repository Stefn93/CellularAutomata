package cellularTransport.patterns;

import cellularTransport.CTCellType;
import cellularTransport.CTStateList;
import fcast.universe2d.GridPattern;

public class GlucoseATPCarrier extends GridPattern<CTCellType> {

	@Override
	public CTCellType[][] get() {
		return new CTCellType[][] {{new CTStateList().get("Glucose ATP Carrier")}, {new CTStateList().get("Glucose ATP Carrier")}};
	}
	
}
