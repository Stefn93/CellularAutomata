package framework.simulation;

import framework.worldmodel.World;

/**
 * 
 * Definisce il comportamento dell'automa
 * @param <CellType> tipo di cellula
 */
public interface Behaviour<CellType> {
    //public CellType calculateNewValue(CellType currentValue, World<CellType> grid, Coordinates coordinates);
    public void calculateGrid(World<CellType> grid);
}
