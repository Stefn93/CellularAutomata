package fcast.universe.world.bidimensional;

import fcast.universe.world.cell.CellType;
import fcast.universe.world.cell.Pattern;
import fcast.universe.world.cell.StateList;

/**
 * Classe che descrive pattern di celle vicine in un mondo bidimensionale
 * 
 *
 * @param <T>
 *            tipo di celle
 */
public abstract class GridPattern<T extends CellType> implements Pattern {
	protected StateList<T> list;

	@Override
	public abstract T[][] get();

	@Override
	public String toString() {
		return this.getClass().getSimpleName();
	}
}
