package cellularTransport;

import framework.universe.cell.StateList;
import javafx.scene.paint.Color;

@SuppressWarnings("serial")
public class CTStateList extends StateList<CTCellType>{
	CTStateList() {
		add(new CTCellType("Empty", 0, Color.BLACK));
		add(new CTCellType("Lipids", 1, Color.RED));
		add(new CTCellType("Protein Carrier", 2, Color.DARKSEAGREEN));
		add(new CTCellType("Big Polar Molecules", 3, Color.DARKCYAN));
		add(new CTCellType("Small Polar Molecules", 4, Color.BLUE));
		add(new CTCellType("Ions", 5, Color.FUCHSIA));
	}
}

