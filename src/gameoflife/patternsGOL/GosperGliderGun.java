package gameoflife.patternsGOL;

import framework.universe2d.GridPattern;
import gameoflife.GOLCellType;
import gameoflife.GOLStateList;

public class GosperGliderGun extends GridPattern<GOLCellType> {
    @Override
    public GOLCellType[][] get() {
    	list = new GOLStateList();
    	GOLCellType f = list.get("dead");
    	GOLCellType t = list.get("alive");
        return new GOLCellType[][] {{f, f, f, f, f, f, f, f, f, f, f, f, f, f, f, f, f, f, f, f, f, f, f, f, f, f, f, f, f, f, f, f, f, f, f, f, f, f},
        							{f, f, f, f, f, f, f, f, f, f, f, f, f, f, f, f, f, f, f, f, f, f, f, f, f, t, f, f, f, f, f, f, f, f, f, f, f, f},
        							{f, f, f, f, f, f, f, f, f, f, f, f, f, f, f, f, f, f, f, f, f, f, f, t, f, t, f, f, f, f, f, f, f, f, f, f, f, f},
        							{f, f, f, f, f, f, f, f, f, f, f, f, f, t, t, f, f, f, f, f, f, t, t, f, f, f, f, f, f, f, f, f, f, f, f, t, t, f},
        							{f, f, f, f, f, f, f, f, f, f, f, f, t, f, f, f, t, f, f, f, f, t, t, f, f, f, f, f, f, f, f, f, f, f, f, t, t, f},
        							{f, t, t, f, f, f, f, f, f, f, f, t, f, f, f, f, f, t, f, f, f, t, t, f, f, f, f, f, f, f, f, f, f, f, f, f, f, f},
        							{f, t, t, f, f, f, f, f, f, f, f, t, f, f, f, t, f, t, t, f, f, f, f, t, f, t, f, f, f, f, f, f, f, f, f, f, f, f},
        							{f, f, f, f, f, f, f, f, f, f, f, t, f, f, f, f, f, t, f, f, f, f, f, f, f, t, f, f, f, f, f, f, f, f, f, f, f, f},
        							{f, f, f, f, f, f, f, f, f, f, f, f, t, f, f, f, t, f, f, f, f, f, f, f, f, f, f, f, f, f, f, f, f, f, f, f, f, f},
        							{f, f, f, f, f, f, f, f, f, f, f, f, f, t, t, f, f, f, f, f, f, f, f, f, f, f, f, f, f, f, f, f, f, f, f, f, f, f},
        							{f, f, f, f, f, f, f, f, f, f, f, f, f, f, f, f, f, f, f, f, f, f, f, f, f, f, f, f, f, f, f, f, f, f, f, f, f, f}};
    }
}
