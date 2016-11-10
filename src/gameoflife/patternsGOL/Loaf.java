package gameoflife.patternsGOL;

import fcast.universe2d.GridPattern;
import gameoflife.GOLCellType;
import gameoflife.GOLStateList;

public class Loaf extends GridPattern<GOLCellType> {
    @Override
    public GOLCellType[][] get() {
    	list = new GOLStateList();
    	GOLCellType f = list.get("dead");
    	GOLCellType t = list.get("alive");
        return new GOLCellType[][] {{f, t, t, f}, {t, f, f, t}, {f, t, f, t}, {f, f, t, f}};
    }
}