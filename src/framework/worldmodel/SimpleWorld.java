package framework.worldmodel;

import framework.simulation.Behaviour;

public abstract class SimpleWorld<T> implements World<T>{
	protected Behaviour<T> behaviour;
	protected int generation;
	protected WorldDimension dimensions = new WorldDimension();

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
