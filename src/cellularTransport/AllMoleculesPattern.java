package cellularTransport;

import framework.universe2d.GridPattern;

public class AllMoleculesPattern extends GridPattern<CTCellType> {
    @Override
    public CTCellType[][] get() {
    	CTCellType f = new CTCellType("Big Polar Molecules", 3);
    	CTCellType t = new CTCellType("Small Polar Molecules", 4);
    	CTCellType j = new CTCellType("Ions", 5);
        return new CTCellType[][] {{f, t, f, t}, {j, t, j, f}};
    }
}
