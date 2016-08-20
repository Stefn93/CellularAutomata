package gameoflife;

import java.util.HashMap;

import framework.gui.Drawer;
import framework.universe.cell.Cell;
import framework.universe.cell.SimpleCell;
import javafx.scene.paint.Color;

public class GOLDrawer implements Drawer<Boolean>{
	
	private HashMap<Boolean, Color> map = new HashMap<Boolean, Color>();
	
	public GOLDrawer() {
		//map.put(null, DEAD);
		map.put(true, Color.DARKCYAN);
		map.put(false, DEAD);
	}
	
	@Override
	public Color getColor(Cell<Boolean> cell) {
		return map.get(cell.getValue());
	}
}
