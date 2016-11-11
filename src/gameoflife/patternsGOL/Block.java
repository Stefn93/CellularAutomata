package gameoflife.patternsGOL;

import fcast.universe.world.bidimensional.GridPattern;
import gameoflife.GOLCellType;
import gameoflife.GOLStateList;

public class Block extends GridPattern<GOLCellType> {
    @Override
    public GOLCellType[][] get() {
    	list = new GOLStateList();
    	GOLCellType t = list.get("alive");
        return new GOLCellType[][] {{t, t}, {t, t}};
    }
}