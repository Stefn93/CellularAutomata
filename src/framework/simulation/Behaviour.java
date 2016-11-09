package framework.simulation;

import framework.universe.world.World;
import framework.universe.world.cell.Cell;
import framework.universe.world.cell.CellType;
import framework.universe.world.cell.Coordinates;

/**
 * 
 * Definisce il comportamento dell'automa
 * @param <CellType> tipo di cellula
 */
public interface Behaviour<x extends CellType> {
    public CellType calculateNewValue(World<x> grid, Coordinates coordinates);
    public void calculateGrid(CellType value, World<x> world, Coordinates coordinates);
}

