package gameoflife;

import java.util.HashMap;
import java.util.Map;

import framework.simulation.Behaviour;
import framework.universe.world.cell.Cell;
import framework.universe.world.cell.SimpleCell;
import framework.universe2d.Coordinates2D;
import framework.universe2d.World2D;
import gameoflife.patternsGOL.GosperGliderGun;

public class GOLWorld extends World2D<GOLCellType> {
    public GOLWorld(int height, int length, Behaviour<GOLCellType> rule) {
        super(new GOLStateList(), height, length, rule);
    }
 
    @Override
    protected Cell<GOLCellType> createNewCell() {
        return new SimpleCell<GOLCellType>(list.get("dead"));
    }

	@Override
	public void defaultState() {
		
	}

	@Override
	public void clear() {
		for (int x = 0; x < dimensions.getLength(); x++) {
			for (int y = 0; y < dimensions.getHeight(); y++) {
				this.getCell(new Coordinates2D(x, y)).setValue(list.get("dead"));
			}
		}
	}

	@Override
	public Map<GOLCellType, Integer> getPopulationStatus() {
		GOLStateList states = new GOLStateList();
		Map<GOLCellType, Integer> population = new HashMap<GOLCellType, Integer>();
		for (GOLCellType c:states){
			population.put(c, new Integer(0));
		}
		for (int x = 0; x < dimensions.getLength(); x++) {
			for (int y = 0; y < dimensions.getHeight(); y++) {
				GOLCellType cell = this.getCell(new Coordinates2D(x, y)).getValue();
				population.put(cell, population.get(cell) + 1);
			}
		}
		return population;
	}
 
}
