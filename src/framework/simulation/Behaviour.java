package framework.simulation;

import framework.worldmodel.Cell;
import framework.worldmodel.Coordinates;
import framework.worldmodel.World;

/**
 * 
 * Definisce il comportamento dell'automa
 * @param <CellType> tipo di cellula
 */
public interface Behaviour<CellType> {
    public CellType calculateNewValue(World<CellType> grid, Coordinates coordinates);
    public void calculateGrid(CellType value, World<CellType> world, Coordinates coordinates);
}
