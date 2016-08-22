package gameoflife;

import java.util.ArrayList;
import java.util.List;

import framework.gui.GridGui;
import framework.gui.WorldGui;
import framework.universe2d.GridPattern;

public class GOLBuilder {
	public static WorldGui<Boolean> build() {
		List<GridPattern<Boolean>> list = new ArrayList<GridPattern<Boolean>>();
		list.add(new ToadPattern());
		list.add(new SingleCellPattern());
		
		GridGui<Boolean> gui = new GridGui<Boolean>(70, new GOLDrawer(), new GOLWorld(70, 70, new ConwaysGameOfLifeRule()), list);
		
		return gui;
	}
}
