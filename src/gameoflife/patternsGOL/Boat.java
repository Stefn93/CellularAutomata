package gameoflife.patternsGOL;

import framework.universe2d.GridPattern;
import gameoflife.GOLCellType;
import gameoflife.GOLStateList;

public class Boat extends GridPattern<GOLCellType> {
    @Override
    public GOLCellType[][] get() {
    	list = new GOLStateList();
    	GOLCellType f = list.get("dead");
    	GOLCellType t = list.get("alive");
        return new GOLCellType[][] {{t, t, f}, {t, f, t}, {f, t, f}};
    }
}