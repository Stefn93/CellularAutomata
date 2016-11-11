package sampleCA;


import fcast.universe.world.cell.StateList;
import javafx.scene.paint.Color;

public class SampleStateList extends StateList<SampleCellType> {

	public SampleStateList() {
		super("dead");
		//List of the patterns useful for the CA simulation.
		add(new SampleCellType("empty", 0, Color.BLACK));
	}

}
