package fcast.universe.world.cell;

/**
 * Interfaccia che descrive i metodi di cui è dotata ogni cella
 * 
 *
 * @param <T>
 */
public interface Cell<T extends CellType> {
	/**
	 * Getter per il valore contenuto nella cella
	 * 
	 * @return valore contenuto nella cella
	 */
	public T getValue();

	/**
	 * Setter per il valore nella cela
	 * 
	 * @param value
	 *            nuovo valore da attribuire alla cella
	 */
	public void setValue(T value);

	/**
	 * Conferma la rivalutazione del valore
	 * 
	 * @return true per esito positivo, false per esito negativo
	 */
	public boolean confirmRevaluation();

	/**
	 * Prepara il nuovo valore della cella per evitare un conflitto nel calcolo
	 * dello stato corrente
	 * 
	 * @param cellType
	 *            valore da attribuire allo stato successivo
	 */
	public void revaluateCell(T cellType);
}
