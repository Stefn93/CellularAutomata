package cellularTransport.patterns;

import cellularTransport.CTCellType;
import cellularTransport.CTStateList;
import framework.universe2d.GridPattern;

public class ClATPCarrier extends GridPattern<CTCellType> {

	@Override
	public CTCellType[][] get() {
		return new CTCellType[][] {{new CTStateList().get("Cl ATP Carrier")}, {new CTStateList().get("Cl ATP Carrier")}};
	}
}
