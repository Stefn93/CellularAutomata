package cellularTransport;

import java.util.ArrayList;
import java.util.List;

import cellularTransport.patterns.AllMolecules;
import cellularTransport.patterns.Cl;
import cellularTransport.patterns.Glucose;
import cellularTransport.patterns.Oxygen;
import fcast.gui.GridGui;
import fcast.gui.WorldGui;
import fcast.simulation.CellularAutomataBuilder;
import fcast.universe.world.bidimensional.GridPattern;

/**
 * 
 *
 */
public class CTBuilder extends CellularAutomataBuilder<CTCellType> {

	@Override
	public WorldGui<CTCellType> build() {
		List<GridPattern<CTCellType>> list = new ArrayList<GridPattern<CTCellType>>();
		list.add(new AllMolecules());
		list.add(new Cl());
		list.add(new Glucose());
		list.add(new Oxygen());

		GridGui<CTCellType> gui = new GridGui<CTCellType>(70, new CTWorld(70, 70, new CellularTransportRule()), list);
		gui.setMouseListener(new Cl());

		return gui;
	}

}
