package framework.world2d;

import framework.universe.cell.Pattern;

public abstract class GridPattern<T> implements Pattern {
    public abstract T[][] get();
}