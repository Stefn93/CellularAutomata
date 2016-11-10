package gameoflife;

import fcast.universe.world.cell.CellType;
import fcast.universe.world.cell.StateList;
import javafx.scene.paint.Color;

@SuppressWarnings("serial")
public class GOLStateList extends StateList<GOLCellType>{
	public GOLStateList() {
		super("dead");
		add(new GOLCellType("dead", false, CellType.DEAD));
		add(new GOLCellType("alive", true, Color.DARKCYAN));
	}
}

