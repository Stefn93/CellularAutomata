package gameoflife.patternsGOL;

import fcast.universe.world.bidimensional.GridPattern;
import gameoflife.GOLCellType;
import gameoflife.GOLStateList;

public class Single extends GridPattern<GOLCellType>{

	@Override
	public GOLCellType[][] get() {
		list = new GOLStateList();
		return new GOLCellType[][] {{list.get("alive")}};
	}

}

