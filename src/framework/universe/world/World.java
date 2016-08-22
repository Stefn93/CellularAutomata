package framework.universe.world;

import framework.universe.cell.Cell;
import framework.universe.cell.Coordinates;
import framework.universe.cell.Pattern;

public interface World<T> {
 
    public void nextState();
    public Cell<T> getCell(Coordinates coordinates);
    public int getGeneration();
    public WorldDimension getDimensions();
    public void addPattern(Pattern pattern, Coordinates coordinates);
	public void reset();

}