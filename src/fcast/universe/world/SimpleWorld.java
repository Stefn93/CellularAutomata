package fcast.universe.world;

import fcast.universe.world.cell.CellType;
import fcast.universe.world.cell.Coordinates;
import fcast.universe.world.cell.StateList;

/**
 * Classe astratta che implementa metodi validi per ogni mondo su cui si
 * svolgono le simulazioni
 * 
 *
 * @param <T>
 *            tipo di cella presente nella simulazione
 */
public abstract class SimpleWorld<T extends CellType> implements World<T> {
	/**
	 * Comportamento del mondo
	 */
	protected Behaviour<T> behaviour;
	/**
	 * Generazione corrente
	 */
	protected int generation;
	/**
	 * Dimensioni del mondo
	 */
	protected WorldDimension dimensions = new WorldDimension();
	/**
	 * Velocità di evoluzione dell'automa
	 */
	protected int evolutionRate;
	/**
	 * Lista degli stati assumibili dall'automa
	 */
	protected StateList<T> list;

	@Override
	public int getEvolutionRate() {
		return evolutionRate;
	}

	@Override
	public void incrementEvolutionRate() {
		evolutionRate++;
	}

	public SimpleWorld(Behaviour<T> behaviour) {
		this.behaviour = behaviour;
	}

	@Override
	public int getGeneration() {
		return generation;
	}

	/**
	 * Setter per la generazione
	 * 
	 * @param generation
	 *            generazione da settare.
	 */
	public void setGeneration(int generation) {
		this.generation = generation;
	}

	@Override
	public boolean isDead(Coordinates coord) {
		return (getCell(coord).getValue().equals(list.getDead()) || getCell(coord) == null);
	}

	@Override
	public WorldDimension getDimensions() {
		return dimensions;
	}

	@Override
	public String getInfo() {
		return null;
	}

}
