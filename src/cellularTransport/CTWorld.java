package cellularTransport;

import java.util.HashMap;
import java.util.Map;



import framework.simulation.Behaviour;
import framework.universe.cell.Cell;
import framework.universe.cell.SimpleCell;
import framework.universe2d.Coordinates2D;
import framework.universe2d.World2D;

public class CTWorld extends World2D<CTCellType> {
	
    public CTWorld(int height, int length, Behaviour<CTCellType> rule) {
        super(new CTStateList(), height, length, rule);
    }
 
    @Override
    protected Cell<CTCellType> createNewCell() {
        return new SimpleCell<CTCellType>(list.get("Empty"));
    }

	@Override
	public void defaultState() {
		for(int i = 0; i < dimensions.getHeight(); i++){
			if(i % 10 == 0)
				addPattern(new ProteinChannelPattern(), new Coordinates2D(34, i));
			else
				addPattern(new MembranePattern(), new Coordinates2D(34, i));
		}
	}

	@Override
	public void clear() {
		for (int x = 0; x < dimensions.getLength(); x++) {
			for (int y = 0; y < dimensions.getHeight(); y++) {
				this.getCell(new Coordinates2D(x, y)).setValue(list.get("Empty"));
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
				population.put(cell, population.get(cell) + 1);
			}
		}
		return population;
	}

 
}
