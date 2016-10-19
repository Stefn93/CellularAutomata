package cellularTransport.patterns;

import cellularTransport.CTCellType;
import cellularTransport.CTStateList;
import framework.universe2d.GridPattern;


public class AllMolecules extends GridPattern<CTCellType> {
    @Override
    public CTCellType[][] get() {
    	CTStateList list = new CTStateList();
    	CTCellType f = list.get("Glucose");
    	CTCellType t = list.get("Oxygen");
    	CTCellType j = list.get("Cl");
        return new CTCellType[][] {{f, f, f, f}, {t, t, t, t}, {j, j, j, j}};
    }
}
