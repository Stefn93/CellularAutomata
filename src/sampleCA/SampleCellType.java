package sampleCA;

import fcast.universe.world.cell.CellType;
import javafx.scene.paint.Color;

public class SampleCellType extends CellType {

	//Defines the value type, depending on the Cellular Automaton type of cells. In this example it's an int.
	protected SampleCellType(String valueName, int value, Color color) {
		super(valueName, value, color);
	}
	
}
