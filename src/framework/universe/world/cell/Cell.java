package framework.universe.world.cell;

import gameoflife.GOLCellType;

public interface Cell<T extends CellType> {
    public T getValue();
    public void setValue(T value);
    boolean confirmRevaluation();
	void revaluateCell(T cellType);
}