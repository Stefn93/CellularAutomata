package framework.universe.world;

import framework.universe.cell.Cell;
import framework.universe.cell.Coordinates;

public interface World<T> {
 
    public void nextState();
    public Cell<T> getCell(Coordinates coordinates);
    public int getGeneration();
    public WorldDimension getDimensions();
}