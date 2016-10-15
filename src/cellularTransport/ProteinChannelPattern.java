package cellularTransport;

import framework.universe2d.GridPattern;

public class ProteinChannelPattern extends GridPattern<CTCellType>{

	@Override
	public CTCellType[][] get() {
		return new CTCellType[][] {{new CTCellType("Protein Carrier", 2), new CTCellType("Protein Carrier", 2)}};
	}

}
