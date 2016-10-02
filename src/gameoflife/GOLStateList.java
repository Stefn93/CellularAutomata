package gameoflife;

import framework.universe.cell.StateList;

public class GOLStateList extends StateList<GOLCellType>{
	GOLStateList() {
		add(new GOLCellType("Dead", false));
		add(new GOLCellType("Alive", true));
	}
}
