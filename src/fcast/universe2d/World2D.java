package fcast.universe2d;

import fcast.simulation.Behaviour;
import fcast.universe.world.SimpleWorld;
import fcast.universe.world.cell.Cell;
import fcast.universe.world.cell.CellType;
import fcast.universe.world.cell.Coordinates;
import fcast.universe.world.cell.Pattern;
import fcast.universe.world.cell.SimpleCell;
import fcast.universe.world.cell.StateList;
import gameoflife.GOLCellType;

public abstract class World2D<x extends CellType> extends SimpleWorld<x> {

	private Cell<x>[][] grid;	
	
	@SuppressWarnings("unchecked")
	public World2D(StateList<x> stateList, int height, int length, Behaviour<x> behaviour){
		super(behaviour);
		this.list = stateList;
		dimensions.setHeight(height);
		dimensions.setLength(length);
		this.grid = new Cell[height][length];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < length; x++) {
                grid[y][x] = createNewCell();
            }
        }
        defaultState();
	}

    @Override
    public void addPattern(Pattern pattern, Coordinates coordinates) {
        @SuppressWarnings("unchecked")
        CellType[][] patternValues = ((GridPattern<CellType>)pattern).get();
        Coordinates2D gridCoordinates = ((Coordinates2D)coordinates);
        for (int y = gridCoordinates.getY(); y < dimensions.getHeight() && y < gridCoordinates.getY() + patternValues.length; y++) {
            for (int x = gridCoordinates.getX(); x < dimensions.getLength() && x < gridCoordinates.getX() + patternValues[0].length; x++) {
            	if (y > dimensions.getHeight() || y < 0 || x < 0 || x > dimensions.getLength()) continue;
            	if (this.isDead(new Coordinates2D(x, y)))
            		grid[x][y].setValue((x) patternValues[y - gridCoordinates.getY()][x - gridCoordinates.getX()]);
            }
        }
    }
	
    
	@Override
	public void nextState() {
		evolutionRate = 0;
		for (int i = 0; i < dimensions.getLength(); i++) {
			for (int j = 0; j < dimensions.getHeight(); j++) {	
				grid[i][j].revaluateCell((x) behaviour.calculateNewValue(this, new Coordinates2D(i, j)));
			}
		}
		for (int i = 0; i < dimensions.getLength(); i++) {
			for (int j = 0; j < dimensions.getHeight(); j++) {
				if(!((SimpleCell) grid[i][j]).isRevaluated())
					if(grid[i][j].confirmRevaluation())
						evolutionRate++;
			}
		}
	}
	
	public void nextStateCell(CellType cell, Coordinates2D coordinates) {
		grid[coordinates.getX()][coordinates.getY()].revaluateCell((x) cell);
		grid[coordinates.getX()][coordinates.getY()].confirmRevaluation();
	}

	@Override
	public Cell<x> getCell(Coordinates coordinates) {
		Coordinates2D c = (Coordinates2D) coordinates;
		int x = c.getX();
		int y = c.getY();
        if (x < 0 || y < 0 || x >= dimensions.getLength() || y >= dimensions.getHeight()) {
        	return null;
        }
        return grid[c.getX()][c.getY()];
	}
	
    protected abstract Cell<x> createNewCell();
    protected abstract void clear();
    protected abstract void defaultState();
    
    public void reset() {
    	clear();
    	defaultState();
    }


}