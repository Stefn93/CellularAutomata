package cellularTransport;

import framework.universe2d.GridPattern;

public class MembranePattern extends GridPattern<CTCellType>{

	@Override
	public CTCellType[][] get(){
		return new CTCellType[][] {{new CTCellType("Lipids", 1), new CTCellType("Lipids", 1)}};
	}
}