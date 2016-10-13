package framework.universe.world;

import framework.simulation.Behaviour;
import framework.universe.cell.CellType;

public abstract class SimpleWorld<T extends CellType> implements World<T>{
	protected Behaviour<T> behaviour;
	protected int generation;
	protected WorldDimension dimensions = new WorldDimension();
	protected int evolutionRate;


	public int getEvolutionRate(){
		return evolutionRate;
	}
	
	public SimpleWorld(Behaviour<T> behaviour) {
		this.behaviour = behaviour;
	}
	
	public int getGeneration() {
		return generation;
	}

	public void setGeneration(int generation) {
		this.generation = generation;
	}


	@Override
	public WorldDimension getDimensions() {
		return dimensions;
	}

}

