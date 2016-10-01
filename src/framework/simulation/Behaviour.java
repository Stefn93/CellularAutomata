package framework.simulation;

import framework.universe.cell.Cell;
import framework.universe.cell.Coordinates;
import framework.universe.world.World;

/**
 * 
 * Definisce il comportamento dell'automa
 * @param <CellType> tipo di cellula
 */
public interface Behaviour<CellType> {
    public CellType calculateNewValue(World<CellType> grid, Coordinates coordinates);
    public void calculateGrid(CellType value, World<CellType> world, Coordinates coordinates);
    public StateList<CellType> getStateList();
}
