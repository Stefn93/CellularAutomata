package framework.gui;

import java.util.List;

import framework.universe.cell.Pattern;
import framework.universe.world.World;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

public abstract class WorldGui<T> {
	protected World<T> world;
	protected Drawer<T> drawer;
	protected List<? extends Pattern> patternList;
	protected Node node;

	public WorldGui(Drawer<T> drawer, World<T> world, List<? extends Pattern> patternList) {
		this.patternList = patternList;
		this.world = world;
		this.drawer = drawer;
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