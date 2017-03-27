package fcast.simulation;

import java.io.IOException;

/**
 * Interfaccia che descrive i metodi per ogni grafico
 * 
 *
 */
public interface CellularAutomatonChart {
	/**
	 * Funzione utilizzata per il salvataggio dei dati di un grafico su file
	 * 
	 * @param dataName
	 *            Nome del file su cui salvare i dati in formato testuale
	 * @param imgName
	 *            Nome dell'immagine su cui salvare l'istantanea del grafico
	 * @throws IOException
	 */
	public void save(String dataName, String imgName) throws IOException;

	/**
	 * Funzione per il reset del grafico
	 */
	public void reset();

	/**
	 * Funzione per aggiornare i dati del grafico
	 * 
	 * @param generation
	 *            Generazione di riferimento
	 * @param o
	 *            Informazione da inserire nel grafico
	 */
	public void updateInfo(int generation, Object o);
}
