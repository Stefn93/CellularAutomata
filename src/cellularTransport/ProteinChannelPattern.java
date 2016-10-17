package cellularTransport;

import framework.universe2d.GridPattern;

public class ProteinChannelPattern extends GridPattern<CTCellType>{

	@Override
	public CTCellType[][] get() {
		return new CTCellType[][] {{new CTStateList().get("Protein Carrier"), new CTStateList().get("Protein Carrier")}};
	}

}
