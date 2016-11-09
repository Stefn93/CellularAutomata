package framework.universe.world;

import java.util.Map;

import framework.universe.world.cell.Cell;
import framework.universe.world.cell.CellType;
import framework.universe.world.cell.Coordinates;
import framework.universe.world.cell.Pattern;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart.Data;

public interface World<T extends CellType> {
 
    public void nextState();
    public Cell<T> getCell(Coordinates coordinates);
    public int getGeneration();
    public WorldDimension getDimensions();
    public void addPattern(Pattern pattern, Coordinates coordinates);
	public void reset();
	public Map<T, Integer> getPopulationStatus();
	public int getEvolutionRate();
	public void incrementEvolutionRate();
	public boolean isDead(Coordinates coordinates);
	public String getInfo();

}
