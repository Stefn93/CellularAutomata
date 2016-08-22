package gameoflife;

import framework.simulation.Behaviour;
import framework.universe.cell.Cell;
import framework.universe.cell.Coordinates;
import framework.universe.cell.Pattern;
import framework.universe.cell.SimpleCell;
import framework.universe2d.Coordinates2D;
import framework.universe2d.World2D;

public class GOLWorld extends World2D<Boolean> {
    public GOLWorld(int height, int length, Behaviour<Boolean> rule) {
        super(height, length, rule);
    }
 
    @Override
    protected Cell<Boolean> createNewCell() {
        return new SimpleCell<Boolean>(false);
    }

	@Override
	public void defaultState() {
        addPattern(new ToadPattern(), new Coordinates2D(30, 30));		
	}

	@Override
	public void clear() {
		for (int x = 0; x < dimensions.getLength(); x++) {
			for (int y = 0; y < dimensions.getHeight(); y++) {
				this.getCell(new Coordinates2D(x, y)).setValue(false);
			}
		}
	}

 
}