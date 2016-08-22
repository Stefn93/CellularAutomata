package gameoflife;

import framework.universe2d.GridPattern;

public class SingleCellPattern extends GridPattern<Boolean>{

	@Override
	public Boolean[][] get() {
		return new Boolean[][] {{true}};
	}

}
