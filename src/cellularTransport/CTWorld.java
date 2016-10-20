package cellularTransport;

import java.util.HashMap;
import java.util.Map;

import cellularTransport.patterns.ClATPCarrier;
import cellularTransport.patterns.ClCarrier;
import cellularTransport.patterns.GlucoseATPCarrier;
import cellularTransport.patterns.GlucoseCarrier;
import cellularTransport.patterns.Membrane;
import framework.simulation.Behaviour;
import framework.universe.cell.Cell;
import framework.universe.cell.SimpleCell;
import framework.universe2d.Coordinates2D;
import framework.universe2d.World2D;

public class CTWorld extends World2D<CTCellType> {
	
	//Energy
    private int atp = 10; 

	public CTWorld(int height, int length, Behaviour<CTCellType> rule) {
        super(new CTStateList(), height, length, rule);
        setGeneration(0);
    }
 
    @Override
    protected Cell<CTCellType> createNewCell() {
        return new SimpleCell<CTCellType>(list.get("Empty"));
    }

	@Override
	public void defaultState() {
		for(int i = 0; i < dimensions.getLength(); i++){
			if(i % 17 == 13){
				addPattern(new GlucoseCarrier(), new Coordinates2D(i, 34));
				addPattern(new GlucoseATPCarrier(), new Coordinates2D(++i, 34));
			}
			else if(i % 17 == 5){
				addPattern(new ClCarrier(), new Coordinates2D(i, 34));
				addPattern(new ClATPCarrier(), new Coordinates2D(++i, 34));
			}
			else
				addPattern(new Membrane(), new Coordinates2D(i, 34));
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
		
		incrementGeneration();
		if(getGeneration() % 100 == 0)
			atp += 5;
		
		Map<CTCellType, Integer> population = new HashMap<CTCellType, Integer>();
		for (CTCellType c:list){
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
	
	private void incrementGeneration(){
		generation = getGeneration() + 1;
	}
	
	public int getAtp() {
		return atp;
	}
	
	public void decrementATP(){
		atp--;
	}

	@Override
	public String getInfo() {
		return "Available ATP: " + this.atp;
	}
 
}
