package fcast.gui;

import java.util.List;

import fcast.universe.world.World;
import fcast.universe.world.cell.CellType;
import fcast.universe.world.cell.Pattern;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

public abstract class WorldGui<T extends CellType> {
	protected World<T> world;
	protected List<? extends Pattern> patternList;
	protected Node node;

	public WorldGui(World<T> world, List<? extends Pattern> patternList) {
		this.patternList = patternList;
		this.world = world;
	}
	
	public World<T> getWorld() {
		return world;
	}
	
	public Node getNode() {
		return node;
	}
	
	public List<? extends Pattern> getPatternList() {
		return patternList;
	}
	
	public abstract void showWorld();
    public abstract void setMouseListener(Pattern pattern);
}