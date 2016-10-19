package cellularTransport.patternsCT;

import cellularTransport.CTCellType;
import cellularTransport.CTStateList;
import framework.universe2d.GridPattern;

public class Membrane extends GridPattern<CTCellType>{

	@Override
	public CTCellType[][] get(){
		return new CTCellType[][] {{new CTStateList().get("Lipids")},{new CTStateList().get("Lipids")}};
	}
}
