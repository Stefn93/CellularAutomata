package fcast.simulation;

import fcast.universe.world.World;
import fcast.universe.world.cell.Cell;
import fcast.universe.world.cell.CellType;
import fcast.universe.world.cell.Coordinates;

/**
 * 
 * Definisce il comportamento dell'automa
 * @param <CellType> tipo di cellula
 */
public interface Behaviour<x extends CellType> {
    public CellType calculateNewValue(World<x> grid, Coordinates coordinates);
    public void calculateGrid(CellType value, World<x> world, Coordinates coordinates);
}

