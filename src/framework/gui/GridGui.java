package framework.gui;

import framework.universe.cell.Cell;
import framework.universe.world.World;
import framework.universe2d.Coordinates2D;
import framework.universe2d.World2D;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Screen;

public class GridGui<T> extends Pane implements WorldGui<T>{
	private Rectangle[][] rec;
	private Drawer<T> drawer;
	private double height;
	private int n;
	
	
	public GridGui(int n, Drawer<T> drawer) {
		super();
		this.drawer = drawer;
		this.n = n;
		rec = new Rectangle[n][n];
		height = 690/n;
	    for(int i=0; i<n; i++){
	        for(int j=0; j<n; j++){
	            rec[i][j] = new Rectangle();
	            rec[i][j].setX((i + 2) * height);
	            rec[i][j].setY((j + 5) * height);
	            rec[i][j].setWidth(height);
	            rec[i][j].setHeight(height);
	            rec[i][j].setFill(Color.BLACK);
	            rec[i][j].setStroke(Color.DARKGREY);
	            getChildren().add(rec[i][j]);
	        }
	    }
	    
	}
	
	public double getScreenHeight(){
		return height;
	}
	
	private void fillCell(Cell<T> cell, int x, int y){
		rec[x][y].setFill(drawer.getColor(cell));
	}

	@Override
	public void showWorld(World<T> world) {
		World2D<T> w = (World2D<T>) world;
		for (int x = 0; x < w.getDimensions().getLength(); x++) {
			for (int y = 0; y < w.getDimensions().getHeight(); y++) {
				fillCell(w.getCell(new Coordinates2D(x, y)), x, y);
			}
		}
		
	}
}

