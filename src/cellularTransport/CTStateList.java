package cellularTransport;

import framework.universe.cell.StateList;
import javafx.scene.paint.Color;

@SuppressWarnings("serial")
public class CTStateList extends StateList<CTCellType>{
	public CTStateList() {
		super("Empty");
		add(new CTCellType("Empty", 0, Color.BLACK));
		add(new CTCellType("Lipids", 1, Color.LEMONCHIFFON));
		//Molecules
		add(new CTCellType("Glucose", 2, Color.PINK));
		add(new CTCellType("Oxygen", 3, Color.RED));
		add(new CTCellType("Cl", 4, Color.BLUE));
		//Carrier
		add(new CTCellType("Glucose Carrier", 5, Color.LIGHTPINK));
		add(new CTCellType("Cl Carrier", 6, Color.LIGHTBLUE));
		//ATP Carrier
		add(new CTCellType("Glucose ATP Carrier", 7, Color.FUCHSIA));
		add(new CTCellType("Cl ATP Carrier", 8, Color.DARKBLUE));
	}
}

