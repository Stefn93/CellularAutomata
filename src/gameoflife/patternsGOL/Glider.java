package gameoflife.patternsGOL;

import fcast.universe.world.bidimensional.GridPattern;
import gameoflife.GOLCellType;
import gameoflife.GOLStateList;

public class Glider extends GridPattern<GOLCellType> {
    @Override
    public GOLCellType[][] get() {
    	list = new GOLStateList();
    	GOLCellType f = list.get("dead");
    	GOLCellType t = list.get("alive");
        return new GOLCellType[][] {{t, f, f}, {f, t, t}, {t, t, f}};
    }
}