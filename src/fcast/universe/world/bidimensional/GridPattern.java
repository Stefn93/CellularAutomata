package fcast.universe.world.bidimensional;

import fcast.universe.world.cell.CellType;
import fcast.universe.world.cell.Pattern;
import fcast.universe.world.cell.StateList;

public abstract class GridPattern<T extends CellType> implements Pattern {
    public abstract T[][] get();
    protected StateList<T> list;
    public String toString(){
    	return this.getClass().getSimpleName();
    }
}
