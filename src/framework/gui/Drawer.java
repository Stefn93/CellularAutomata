package framework.gui;

import framework.worldmodel.Coordinates;
import framework.worldmodel.World;

/**
 * 
 * Drawer per il mondo
 *
 * @param <T>
 */
public interface Drawer<T> {

	public void redraw(World<T> grid, Coordinates coord);
	public void redrawAll(World<T> grid, Coordinates coord);
}
