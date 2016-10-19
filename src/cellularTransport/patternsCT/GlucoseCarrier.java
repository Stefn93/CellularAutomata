package cellularTransport.patternsCT;

import cellularTransport.CTCellType;
import cellularTransport.CTStateList;
import framework.universe2d.GridPattern;

public class GlucoseCarrier extends GridPattern<CTCellType>{

	@Override
	public CTCellType[][] get() {
		return new CTCellType[][] {{new CTStateList().get("Glucose Carrier")}, {new CTStateList().get("Glucose Carrier")}};
	}

}
