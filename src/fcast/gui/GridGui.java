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

public class GridGui<T extends CellType> extends WorldGui<T>{
	private Rectangle[][] rec;
	private double height;
	
	public GridGui(int n, World2D<T> world, List<GridPattern<T>> patternList) {
		super(world, patternList);
		node = new Pane();
		rec = new Rectangle[n][n];
		height = 690/n;
	    for(int i=0; i<n; i++){
	        for(int j=0; j<n; j++){
	            rec[i][j] = new Rectangle();
	            rec[i][j].setX((i) * height);
	            rec[i][j].setY((j) * height);
	            rec[i][j].setWidth(height);
	            rec[i][j].setHeight(height);
	            rec[i][j].setFill(Color.BLACK);
	            rec[i][j].setStroke(Color.DARKSLATEGREY);
	            ((Pane)node).getChildren().add(rec[i][j]);
	        }
	    }
	    
	}
	
	
	private void fillCell(Cell<T> cell, int x, int y){
		rec[x][y].setFill(cell.getValue().getColor());
	}

	@Override
	public void showWorld() {
		for (int x = 0; x < world.getDimensions().getLength(); x++) {
			for (int y = 0; y < world.getDimensions().getHeight(); y++) {
				fillCell(world.getCell(new Coordinates2D(x, y)), x, y);
			}
		}
		
	}

	
	public void setMouseListener(Pattern pattern) {
	    ((Pane)node).setOnMouseDragged(new EventHandler<MouseEvent>() {
	    	public void handle(MouseEvent m) {
	    		double x = m.getX();
	    		double y = m.getY();
	    		
	    		int colX = (int) (x/height);
	    		int colY = (int) (y/height);
	    		Coordinates coord = new Coordinates2D(colX, colY);
	    		
    			world.addPattern(pattern, coord);
	    	}
	    });
	    ((Pane)node).setOnMouseClicked(new EventHandler<MouseEvent>() {
	    	public void handle(MouseEvent m) {
	    		double x = m.getX();
	    		double y = m.getY();
	    		
	    		int colX = (int) (x/height);
	    		int colY = (int) (y/height);
	    		Coordinates coord = new Coordinates2D(colX, colY);
    			world.addPattern(pattern, coord);
	    	}
	    });
	}
}

