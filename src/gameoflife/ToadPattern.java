package gameoflife;

import framework.universe2d.GridPattern;

public class ToadPattern extends GridPattern<GOLCellType> {
    @Override
    public GOLCellType[][] get() {
    	list = new GOLStateList();
    	GOLCellType f = list.get("dead");
    	GOLCellType t = list.get("alive");
        return new GOLCellType[][] {{f, t, t, t}, {t, t, t, f}};
    }
}
