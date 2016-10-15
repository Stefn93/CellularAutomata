package cellularTransport;

import framework.universe.cell.StateList;

public class CTStateList extends StateList<CTCellType>{
	CTStateList() {
		add(new CTCellType("Empty", 0));
		add(new CTCellType("Lipids", 1));
		add(new CTCellType("Protein Carrier", 2));
		add(new CTCellType("Big Polar Molecules", 3));
		add(new CTCellType("Small Polar Molecules", 4));
		add(new CTCellType("Ions", 5));
	}
}

