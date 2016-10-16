package framework.universe2d;

import framework.universe.cell.CellType;
import framework.universe.cell.Pattern;
import framework.universe.cell.StateList;

public abstract class GridPattern<T extends CellType> implements Pattern {
    public abstract T[][] get();
    protected StateList<T> list;
    public String toString(){
    	return this.getClass().getSimpleName();
    }
}
