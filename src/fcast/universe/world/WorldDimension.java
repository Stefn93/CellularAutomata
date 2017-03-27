package fcast.universe.world;

/**
 * Classe che definisce le grandezze per i vari mondi
 *
 */
public class WorldDimension {
	private int length;
	private int height;
	private int depth;

	/**
	 * Getter per la lunghezza del mondo
	 * 
	 * @return
	 */
	public int getLength() {
		return length;
	}

	/**
	 * Setter per la lunghezza
	 * 
	 * @param length
	 *            lunghezza da impostare
	 */
	public void setLength(int length) {
		this.length = length;
	}

	/**
	 * Getter per l'altezza del mondo
	 * 
	 * @return
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Setter per l'altezza del mondo
	 * 
	 * @param height
	 *            altezza da impostare
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * Getter per la profondità del mondo
	 * 
	 * @return profondità
	 */
	public int getDepth() {
		return depth;
	}

	/**
	 * Setter per la profondità del mondo
	 * 
	 * @param depth
	 *            nuova profondità
	 */
	public void setDepth(int depth) {
		this.depth = depth;
	}
}
