package gameoflife;

import framework.universe.cell.CellType;
import framework.universe.cell.StateList;
import javafx.scene.paint.Color;

public class GOLStateList extends StateList<GOLCellType>{
	GOLStateList() {
		add(new GOLCellType("dead", false, CellType.DEAD));
		add(new GOLCellType("alive", true, Color.DARKCYAN));
	}
}

