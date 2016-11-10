package cellularTransport.patterns;

import cellularTransport.CTCellType;
import cellularTransport.CTStateList;
import fcast.universe2d.GridPattern;

public class Oxygen extends GridPattern<CTCellType> {

	@Override
	public CTCellType[][] get() {
		return new CTCellType[][] {{new CTStateList().get("Oxygen")}};
	}

}
