package fcast.universe.world.cell;

/**
 * Classe astratta che implementa alcuni metodi validi per ogni cella
 *
 * @param <T>
 */
public class SimpleCell<T extends CellType> implements Cell<T> {

	private T value;
	private T revaluatedValue;
	private boolean revaluated = false;

	public SimpleCell(T value) {
		super();
		this.value = value;
	}

	@Override
	public T getValue() {
		return value;
	}

	@Override
	public void revaluateCell(T nvalue) {
		setRevaluated(false);
		revaluatedValue = nvalue;
	}

	@Override
	public boolean confirmRevaluation() {
		if (!value.equals(revaluatedValue)) {
			setRevaluated(true);
			value = revaluatedValue;
			revaluatedValue = null;
			return true;
		}
		return false;
	}

	@Override
	public void setValue(T nvalue) {
		this.value = nvalue;
	}

	/**
	 * Funzione per verificare la rivalutazione di una cella
	 * 
	 * @return true se la cella è stata rivalutata, false altrimenti
	 */
	public boolean isRevaluated() {
		return revaluated;
	}

	/**
	 * Cambia lo stato del flag indicante la rivalutazione della cella
	 * 
	 * @param nrevaluated
	 *            nuovo valore del flag
	 */
	public void setRevaluated(boolean nrevaluated) {
		this.revaluated = nrevaluated;
	}

	public boolean equals(SimpleCell<T> c) {
		return c.getValue().equals(this.getValue());
	}

}