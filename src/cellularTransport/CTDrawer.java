package cellularTransport;

import java.util.HashMap;

import framework.gui.Drawer;
import framework.universe.cell.Cell;
import framework.universe.cell.SimpleCell;
import javafx.scene.paint.Color;

public class CTDrawer implements Drawer<CTCellType>{
	
	private HashMap<CTCellType, Color> map = new HashMap<CTCellType, Color>();
	
	public CTDrawer() {
		//map.put(null, DEAD);
		map.put(new CTCellType("Empty", 0), DEAD);
		map.put(new CTCellType("Lipids", 1), Color.RED);
		map.put(new CTCellType("Protein Carrier", 2), Color.DARKSEAGREEN);
		map.put(new CTCellType("Big Polar Molecules", 3), Color.DARKCYAN);
		map.put(new CTCellType("Small Polar Molecules", 4), Color.BLUE);
		map.put(new CTCellType("Ions", 5), Color.FUCHSIA);
	}
	
	@Override
	public Color getColor(Cell<CTCellType> cell) {
		return map.get(cell.getValue());
	}
}

