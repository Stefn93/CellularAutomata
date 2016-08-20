package gameoflife;

import java.util.HashMap;

import framework.gui.Drawer;
import framework.universe.cell.SimpleCell;
import javafx.scene.paint.Color;

public class GOLDrawer implements Drawer<Boolean>{
	
	private HashMap<Boolean, Color> map;
	
	GOLDrawer() {
		map.put(true, Color.RED);
		map.put(false, DEAD);
	}
	
	@Override
	public Color getColor(SimpleCell<Boolean> cell) {
		return map.get(cell.getValue());
	}
}
