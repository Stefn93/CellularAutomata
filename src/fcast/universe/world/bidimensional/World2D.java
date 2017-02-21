package fcast.universe.world.bidimensional;

import fcast.universe.world.Behaviour;
import fcast.universe.world.SimpleWorld;
import fcast.universe.world.cell.Cell;
import fcast.universe.world.cell.CellType;
import fcast.universe.world.cell.Coordinates;
import fcast.universe.world.cell.Pattern;
import fcast.universe.world.cell.SimpleCell;
import fcast.universe.world.cell.StateList;

/**
 * Classe che implementa metodi validi per ogni mondo bidimensionale con celle
 * quadrate
 *
 * @param <x>
 *            tipo di cella
 */
public abstract class World2D<x extends CellType> extends SimpleWorld<x> {

	private Cell<x>[][] grid;

	@SuppressWarnings("unchecked")
	public World2D(StateList<x> stateList, int height, int length, Behaviour<x> behaviour) {
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
		CellType[][] patternValues = ((GridPattern<CellType>) pattern).get();
		Coordinates2D gridCoordinates = ((Coordinates2D) coordinates);

		int length = dimensions.getLength();
		int height = dimensions.getHeight();
		int yCoord = gridCoordinates.getY();
		int xCoord = gridCoordinates.getX();
		for (int y = yCoord; y < height && y < yCoord + patternValues.length; y++) {
			for (int x = xCoord; x < length && x < xCoord + patternValues[0].length; x++) {
				if (y > dimensions.getHeight() || y < 0 || x < 0 || x > dimensions.getLength()) {
					continue;
				}
				if (this.isDead(new Coordinates2D(x, y))) {
					grid[x][y].setValue((x) patternValues[y - gridCoordinates.getY()][x - gridCoordinates.getX()]);
				}
			}
		}
	}

	@Override
	public void nextState() {
		evolutionRate = 0;
		int length = dimensions.getLength();
		int height = dimensions.getHeight();
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < height; j++) {
				grid[i][j].revaluateCell((x) behaviour.calculateNewValue(this, new Coordinates2D(i, j)));
			}
		}
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < height; j++) {
				if (!((SimpleCell) grid[i][j]).isRevaluated())
					if (grid[i][j].confirmRevaluation()) {
						evolutionRate++;
					}
			}
		}
	}

	/**
	 * Evolve lo stato di una singola cella identificata dalle coordinate
	 * 
	 * @param cell
	 *            cella da evolvere
	 * @param coordinates
	 *            posizione della cella
	 */
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

	@Override
	public void reset() {
		clear();
		defaultState();
	}

}
