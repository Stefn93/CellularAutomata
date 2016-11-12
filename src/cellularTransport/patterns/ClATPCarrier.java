package cellularTransport.patterns;

import cellularTransport.CTCellType;
import cellularTransport.CTStateList;
import fcast.universe.world.bidimensional.GridPattern;

public class ClATPCarrier extends GridPattern<CTCellType> {

	@Override
	public CTCellType[][] get() {
		return new CTCellType[][] {{new CTStateList().get("Cl Uniporter")}, {new CTStateList().get("Cl Uniporter")}};
	}
}
