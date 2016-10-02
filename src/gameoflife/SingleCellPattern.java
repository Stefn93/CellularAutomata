package gameoflife;

import framework.universe2d.GridPattern;

public class SingleCellPattern extends GridPattern<GOLCellType>{

	@Override
	public GOLCellType[][] get() {
		return new GOLCellType[][] {{new GOLCellType("Alive", true)}};
	}

}
