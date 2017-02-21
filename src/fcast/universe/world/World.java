package fcast.universe.world;

import java.util.Map;

import fcast.universe.world.cell.Cell;
import fcast.universe.world.cell.CellType;
import fcast.universe.world.cell.Coordinates;
import fcast.universe.world.cell.Pattern;

/**
 * Interfaccia per descrivere i metodi di un mondo logico su cui svolgere una
 * simulazione
 *
 * @param <T>
 *            tipo di cella in input
 */
public interface World<T extends CellType> {

	/**
	 * Metodo per avanzare allo stato successivo del mondo
	 */
	public void nextState();

	/**
	 * Getter per la cella identificata dalle coordinate in input
	 * 
	 * @param coordinates
	 *            coordinate indicanti la posizione della cella nel mondo
	 * @return cella
	 */
	public Cell<T> getCell(Coordinates coordinates);

	/**
	 * Getter per il numero della generazione corrente
	 * 
	 * @return generazione corrente
	 */
	public int getGeneration();

	/**
	 * Getter delle dimensioni del mondo
	 * 
	 * @return oggetto di tipo WorldDimension che incapsula le dimensioni del
	 *         mondo
	 */
	public WorldDimension getDimensions();

	/**
	 * Aggiunge un pattern alla coordinata specificata
	 * 
	 * @param pattern
	 *            pattern da aggiungere
	 * @param coordinates
	 *            posizione in cui aggiungere il pattern
	 */
	public void addPattern(Pattern pattern, Coordinates coordinates);

	/**
	 * Metodo per il reset del mondo
	 */
	public void reset();

	/**
	 * Getter per le informazioni sulla popolazione
	 * 
	 * @return tabella hash che associa ad uno stato della simulazione un intero
	 *         indicante il numero di celle di quel tipo
	 */
	public Map<T, Integer> getPopulationStatus();

	/**
	 * Getter per la velocità di evoluzione dell'automa
	 * 
	 * @return velocità di evoluzione dell'automa
	 */
	public int getEvolutionRate();

	/**
	 * Aumenta la velocità di evoluzione
	 */
	public void incrementEvolutionRate();

	/**
	 * Funzione per verificare la morte di una cella
	 * 
	 * @param coordinates
	 *            coordinate della cella da verificare
	 * @return true se la cella è morta, false altrimenti
	 */
	public boolean isDead(Coordinates coordinates);

	/**
	 * Getter per info aggiuntive sul mondo
	 * 
	 * @return stringa indicante le info aggiuntive
	 */
	public String getInfo();

}
