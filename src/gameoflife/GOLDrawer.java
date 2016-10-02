package gameoflife;

import java.util.HashMap;

import framework.gui.Drawer;
import framework.universe.cell.Cell;
import framework.universe.cell.SimpleCell;
import javafx.scene.paint.Color;

public class GOLDrawer implements Drawer<GOLCellType>{
	
	private HashMap<GOLCellType, Color> map = new HashMap<GOLCellType, Color>();
	
	public GOLDrawer() {
		//map.put(null, DEAD);
		map.put(new GOLCellType("Alive", true), Color.DARKCYAN);
		map.put(new GOLCellType("Dead", false), DEAD);
	}
	
	@Override
	public Color getColor(Cell<GOLCellType> cell) {
		return map.get(cell.getValue());
	}
}
