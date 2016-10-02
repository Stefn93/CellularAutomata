package framework.universe.cell;

import gameoflife.GOLCellType;

public interface Cell<T extends CellType> {
    public T getValue();
    public void setValue(T value);
    void confirmRevaluation();
	void revaluateCell(T cellType);
}