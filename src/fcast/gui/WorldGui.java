package fcast.gui;

import java.util.List;

import fcast.universe.world.World;
import fcast.universe.world.cell.CellType;
import fcast.universe.world.cell.Pattern;
import javafx.scene.Node;

/**
 * Interfaccia descrivente i metodi per ogni mondo grafico
 *
 * @param <T>
 *            tipo di cella presente nel mondo
 */
public abstract class WorldGui<T extends CellType> {
	/**
	 * Mondo su cui si svolge la simulazione
	 */
	protected World<T> world;
	/**
	 * Lista dei pattern validi per la simulazione.
	 */
	protected List<? extends Pattern> patternList;
	/**
	 * Nodo della griglia nel graph-scene di JavaFX
	 */
	protected Node node;

	/**
	 * Costruttore per la griglia
	 * 
	 * @param world
	 *            Mondo su cui costruire la griglia
	 * @param patternList
	 *            Lista dei pattern per la simulazione
	 */
	public WorldGui(World<T> world, List<? extends Pattern> patternList) {
		this.patternList = patternList;
		this.world = world;
	}

	/**
	 * Getter per il mondo
	 * 
	 * @return Il mondo
	 */
	public World<T> getWorld() {
		return world;
	}

	/**
	 * Getter per il nodo nello scene-graph
	 * 
	 * @return nodo della griglia
	 */
	public Node getNode() {
		return node;
	}

	/**
	 * Getter per la lista di pattern validi per la simulazione
	 * 
	 * @return
	 */
	public List<? extends Pattern> getPatternList() {
		return patternList;
	}

	/**
	 * Procedura che mostra il mondo nell'interfaccia
	 */
	public abstract void showWorld();

	/**
	 * Setting del listener per il mouse
	 * 
	 * @param pattern
	 */
	public abstract void setMouseListener(Pattern pattern);
}