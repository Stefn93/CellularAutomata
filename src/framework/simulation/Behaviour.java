package framework.simulation;

import framework.universe.cell.Cell;
import framework.universe.cell.CellType;
import framework.universe.cell.Coordinates;
import framework.universe.world.World;

/**
 * 
 * Definisce il comportamento dell'automa
 * @param <CellType> tipo di cellula
 */
public interface Behaviour<x extends CellType> {
    public CellType calculateNewValue(World<x> grid, Coordinates coordinates);
    public void calculateGrid(CellType value, World<x> world, Coordinates coordinates);
}
