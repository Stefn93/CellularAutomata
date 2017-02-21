package fcast.universe.world.cell;

import javafx.scene.paint.Color;

/**
 * Classe astratta per la definizione di un tipo di cella
 *
 */
public abstract class CellType {

	/**
	 * Colore della cella morta
	 */
	public static final Color DEAD = Color.BLACK;

	private String valueName;
	private Object value;
	private Color color;

	protected CellType(String valueName, Object value, Color color) {
		this.valueName = valueName;
		this.value = value;
		this.color = color;
	}

	/**
	 * Getter per il nome del tipo di cella
	 * 
	 * @return nome del tipo di cella in formato stringa
	 */
	public String getValueName() {
		return valueName;
	}

	/**
	 * Getter per il valore associato alla cella
	 * 
	 * @return valore
	 */
	public Object getValue() {
		return value;
	}

	@Override
	public boolean equals(Object e) {
		if (e instanceof CellType) {
			CellType cell = (CellType) e;
			return (valueName.equals(cell.getValueName()) && value.equals(cell.getValue()));
		} else
			return false;
	}

	@Override
	public String toString() {
		return valueName + " " + value;
	}

	/**
	 * Getter per il colore della cella
	 * 
	 * @return colore della cella
	 */
	public Color getColor() {
		return color;
	}

	@Override
	public int hashCode() {
		return valueName.hashCode();
	}
}
