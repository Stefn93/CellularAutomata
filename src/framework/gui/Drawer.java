package framework.gui;

import framework.universe.cell.Cell;
import framework.universe.cell.SimpleCell;
import javafx.scene.paint.Color;

/**
 * 
 * Drawer per il mondo
 *
 * @param <T>
 */
public interface Drawer<T> {
	public static Color DEAD = Color.BLACK;
	
	public Color getColor(Cell<T> cell);
}
