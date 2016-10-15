package cellularTransport;

import framework.universe2d.GridPattern;

public class IonsPattern extends GridPattern<CTCellType>{

	@Override
	public CTCellType[][] get() {
		return new CTCellType[][] {{new CTCellType("Ions", 5)}};
	}

}

