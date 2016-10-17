package gameoflife;

import framework.universe2d.GridPattern;

public class SingleCellPattern extends GridPattern<GOLCellType>{

	@Override
	public GOLCellType[][] get() {
		list = new GOLStateList();
		return new GOLCellType[][] {{list.get("alive")}};
	}

}

