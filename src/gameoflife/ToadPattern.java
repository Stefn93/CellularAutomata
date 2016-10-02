package gameoflife;

import framework.universe2d.GridPattern;

public class ToadPattern extends GridPattern<GOLCellType> {
    @Override
    public GOLCellType[][] get() {
    	GOLCellType f = new GOLCellType("Dead", false);
    	GOLCellType t = new GOLCellType("Alive", true);
        return new GOLCellType[][] {{f, t, t, t}, {t, t, t, f}};
    }
}