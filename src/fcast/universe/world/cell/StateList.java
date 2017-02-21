package fcast.universe.world.cell;

import java.util.HashSet;

/**
 * Lista degli stati di una simulazione
 *
 * @param <T>
 *            tipo di cella della simulazione
 */
@SuppressWarnings("serial")
public class StateList<T extends CellType> extends HashSet<T> {
	/**
	 * Identificatore stringa per la cella morta
	 */
	public static String DEAD;

	/**
	 * Costruttore parametrico per StateList
	 * 
	 * @param dead
	 *            cella morta
	 */
	public StateList(String dead) {
		DEAD = dead;
	}

	/**
	 * Getter per la cella identificata dal valore s
	 * 
	 * @param s
	 *            nome de valore da trovare
	 * @return cella identificata da s
	 */
	public T get(String s) {
		// s = s.toLowerCase();
		for (T t : this) {
			if (t.getValueName().equals(s)) {
				return t;
			}
		}
		return null;
	}

	/**
	 * Getter per la cella morta
	 * 
	 * @return cella corrispondente alla cella morta
	 */
	public T getDead() {
		return get(DEAD);
	}
}
