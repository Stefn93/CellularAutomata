package framework.worldmodel;

import framework.simulation.Behaviour;

public abstract class World2D<CellType> implements World<CellType> {

	private Cell<CellType>[][] grid;
	private Behaviour<CellType> behaviour;
	private WorldDimension dimensions = new WorldDimension();
	private int generation;
	
	
	
	@SuppressWarnings("unchecked")
	public World2D(int height, int lenght, Behaviour<CellType> behaviour){
		dimensions.setHeight(height);
		dimensions.setLength(lenght);
		this.behaviour = behaviour;
		this.grid = new Cell[height][lenght];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < lenght; x++) {
                grid[y][x] = createNewCell();
            }
        }
	}
	
	@Override
	public void nextState() {
		behaviour.calculateGrid(this);
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



	public int getGeneration() {
		return generation;
	}

	public void setGeneration(int generation) {
		this.generation = generation;
	}
}
