package gameoflife.patternsGOL;

import framework.universe2d.GridPattern;
import gameoflife.GOLCellType;
import gameoflife.GOLStateList;

public class Single extends GridPattern<GOLCellType>{

	@Override
	public GOLCellType[][] get() {
		list = new GOLStateList();
		return new GOLCellType[][] {{list.get("alive")}};
	}

}

