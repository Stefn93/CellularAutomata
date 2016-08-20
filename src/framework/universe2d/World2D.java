package framework.universe2d;

import framework.simulation.Behaviour;
import framework.universe.cell.Cell;
import framework.universe.cell.Coordinates;
import framework.universe.cell.Pattern;
import framework.universe.cell.SimpleCell;
import framework.universe.world.SimpleWorld;

public abstract class World2D<CellType> extends SimpleWorld<CellType> {

	private Cell<CellType>[][] grid;	
	
	@SuppressWarnings("unchecked")
	public World2D(int height, int length, Behaviour<CellType> behaviour){
		super(behaviour);
		dimensions.setHeight(height);
		dimensions.setLength(length);
		this.grid = new Cell[height][length];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < length; x++) {
                grid[y][x] = createNewCell();
            }
        }
	}

    @Override
    public void addPattern(Pattern pattern, Coordinates coordinates) {
        @SuppressWarnings("unchecked")
        CellType[][] patternValues = ((GridPattern<CellType>)pattern).get();
        Coordinates2D gridCoordinates = ((Coordinates2D)coordinates);
        for (int y = gridCoordinates.getY(); y < dimensions.getHeight() && y < gridCoordinates.getY() + patternValues.length; y++) {
            for (int x = gridCoordinates.getX(); x < dimensions.getLength() && x < gridCoordinates.getX() + patternValues[0].length; x++) {
                grid[x][y].setValue(patternValues[y - gridCoordinates.getY()][x - gridCoordinates.getX()]);
            }
        }
    }
	
	@Override
	public void nextState() {
		for (int i = 0; i < dimensions.getLength(); i++) {
			for (int j = 0; j < dimensions.getHeight(); j++) {
				grid[i][j].revaluateCell(behaviour.calculateNewValue(this, new Coordinates2D(i, j)));
			}
		}
		for (int i = 0; i < dimensions.getLength(); i++) {
			for (int j = 0; j < dimensions.getHeight(); j++) {
				grid[i][j].confirmRevaluation();
			}
		}
	}

	@Override
	public Cell<CellType> getCell(Coordinates coordinates) {
		Coordinates2D c = (Coordinates2D) coordinates;
		int x = c.getX();
		int y = c.getY();
        if (x < 0 || y < 0 || x >= dimensions.getLength() || y >= dimensions.getHeight()) 
        	return null;
        return grid[c.getX()][c.getY()];
	}
	
    protected abstract Cell<CellType> createNewCell();




}
