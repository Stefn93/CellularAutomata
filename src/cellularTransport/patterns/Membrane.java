package cellularTransport.patterns;

import cellularTransport.CTCellType;
import cellularTransport.CTStateList;
import fcast.universe.world.bidimensional.GridPattern;

public class Membrane extends GridPattern<CTCellType>{

	@Override
	public CTCellType[][] get(){
		return new CTCellType[][] {{new CTStateList().get("Lipids")},{new CTStateList().get("Lipids")}};
	}
}
