package cellularTransport;

import framework.universe2d.GridPattern;


public class AllMoleculesPattern extends GridPattern<CTCellType> {
    @Override
    public CTCellType[][] get() {
    	CTStateList list = new CTStateList();
    	CTCellType f = list.get("Big Polar Molecules");
    	CTCellType t = list.get("Small Polar Molecules");
    	CTCellType j = list.get("Ions");
        return new CTCellType[][] {{f, t, f, t}, {j, t, j, f}};
    }
}
