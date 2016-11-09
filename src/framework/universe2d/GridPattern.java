package framework.universe2d;

import framework.universe.world.cell.CellType;
import framework.universe.world.cell.Pattern;
import framework.universe.world.cell.StateList;

public abstract class GridPattern<T extends CellType> implements Pattern {
    public abstract T[][] get();
    protected StateList<T> list;
    public String toString(){
    	return this.getClass().getSimpleName();
    }
}
