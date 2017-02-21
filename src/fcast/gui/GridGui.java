package fcast.gui;

import java.util.List;

import fcast.universe.world.bidimensional.Coordinates2D;
import fcast.universe.world.bidimensional.GridPattern;
import fcast.universe.world.bidimensional.World2D;
import fcast.universe.world.cell.Cell;
import fcast.universe.world.cell.CellType;
import fcast.universe.world.cell.Coordinates;
import fcast.universe.world.cell.Pattern;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Mondo grafico su cui si svolge la simulazione
 *
 * @param <T>
 *            Tipo di cella della simulazione
 */
public class GridGui<T extends CellType> extends WorldGui<T> {
	/**
	 * Singola cella nella griglia grafica
	 */
	private Rectangle[][] rec;
	/**
	 * Altezza della griglia
	 */
	private double height;

	/**
	 * Costruttore della griglia grafica
	 * 
	 * @param n
	 *            altezza e larghezza della griglia
	 * @param world
	 *            mondo da cui costruire la griglia
	 * @param patternList
	 *            lista dei pattern per la simulazionnne
	 */
	public GridGui(int n, World2D<T> world, List<GridPattern<T>> patternList) {
		super(world, patternList);
		node = new Pane();
		rec = new Rectangle[n][n];
		height = 690 / n;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				rec[i][j] = new Rectangle();
				rec[i][j].setX((i) * height);
				rec[i][j].setY((j) * height);
				rec[i][j].setWidth(height);
				rec[i][j].setHeight(height);
				rec[i][j].setFill(Color.BLACK);
				rec[i][j].setStroke(Color.DARKSLATEGREY);
				((Pane) node).getChildren().add(rec[i][j]);
			}
		}

	}

	/**
	 * Funzione per inserire una cella nella griglia alla colonna x e riga y
	 * 
	 * @param cell
	 *            Cella da inserire
	 * @param x
	 *            riga
	 * @param y
	 *            colonna
	 */
	private void fillCell(Cell<T> cell, int x, int y) {
		rec[x][y].setFill(cell.getValue().getColor());
	}

	/**
	 * Funzione utilizata per mostrare il mondo sulla griglia
	 */
	@Override
	public void showWorld() {

		int length = world.getDimensions().getLength();
		int nheight = world.getDimensions().getHeight();
		for (int x = 0; x < length; x++) {
			for (int y = 0; y < nheight; y++) {
				fillCell(world.getCell(new Coordinates2D(x, y)), x, y);
			}
		}

	}

	/**
	 * Funzione per inserire il mouse listener
	 */
	@Override
	public void setMouseListener(Pattern pattern) {
		((Pane) node).setOnMouseDragged(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent m) {
				double x = m.getX();
				double y = m.getY();

				int colX = (int) (x / height);
				int colY = (int) (y / height);
				Coordinates coord = new Coordinates2D(colX, colY);

				world.addPattern(pattern, coord);
			}
		});
		((Pane) node).setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent m) {
				double x = m.getX();
				double y = m.getY();

				int colX = (int) (x / height);
				int colY = (int) (y / height);
				Coordinates coord = new Coordinates2D(colX, colY);
				world.addPattern(pattern, coord);
			}
		});
	}
}
