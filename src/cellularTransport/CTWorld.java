package cellularTransport;

import java.util.HashMap;
import java.util.Map;

import framework.simulation.Behaviour;
import framework.universe.cell.Cell;
import framework.universe.cell.CellType;
import framework.universe.cell.Coordinates;
import framework.universe.cell.Pattern;
import framework.universe.cell.SimpleCell;
import framework.universe2d.Coordinates2D;
import framework.universe2d.World2D;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart.Data;

public class CTWorld extends World2D<CTCellType> {
    public CTWorld(int height, int length, Behaviour<CTCellType> rule) {
        super(height, length, rule);
    }
 
    @Override
    protected Cell<CTCellType> createNewCell() {
        return new SimpleCell<CTCellType>(new CTCellType("Empty", 0));
    }

	@Override
	public void defaultState() {
		for(int i = 0; i < dimensions.getHeight(); i++){
			if(i % 10 == 0)
				addPattern(new ProteinChannelPattern(), new Coordinates2D(i, 34));
			else
				addPattern(new MembranePattern(), new Coordinates2D(i, 34));
		}
	}

	@Override
	public void clear() {
		for (int x = 0; x < dimensions.getLength(); x++) {
			for (int y = 0; y < dimensions.getHeight(); y++) {
				this.getCell(new Coordinates2D(x, y)).setValue(new CTCellType("Empty", 0));
			}
		}
	}

	@Override
	public Map<CTCellType, Integer> getPopulationStatus() {
		CTStateList states = new CTStateList();
		Map<CTCellType, Integer> population = new HashMap<CTCellType, Integer>();
		for (CTCellType c:states){
			population.put(c, new Integer(0));
		}
		for (int x = 0; x < dimensions.getLength(); x++) {
			for (int y = 0; y < dimensions.getHeight(); y++) {
				CTCellType cell = this.getCell(new Coordinates2D(x, y)).getValue();
				population.put(cell, population.get(cell)+ 1);
			}
		}
		//System.out.println(population);
		return population;
	}

 
}
