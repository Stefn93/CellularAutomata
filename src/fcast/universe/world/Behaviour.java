package fcast.universe.world;

import fcast.universe.world.cell.CellType;
import fcast.universe.world.cell.Coordinates;

/**
 * 
 * Definisce il comportamento dell'automa
 * 
 * @param <CellType>
 *            tipo di cellula
 */
public interface Behaviour<x extends CellType> {
	/**
	 * Calcola il valore di una singola cella
	 * 
	 * @param grid
	 *            stato attuale della griglia
	 * @param coordinates
	 *            coordinate della cella da valutare
	 * @return nuovo valore per la cella
	 */
	public CellType calculateNewValue(World<x> grid, Coordinates coordinates);

	/**
	 * Calcolo dell'intera griglia
	 * 
	 * @param value
	 *            valore della cella allo stato attuale
	 * @param world
	 *            mondo in cui si trova la cella
	 * @param coordinates
	 *            coordinate della cella
	 */
	public void calculateGrid(CellType value, World<x> world, Coordinates coordinates);
}
