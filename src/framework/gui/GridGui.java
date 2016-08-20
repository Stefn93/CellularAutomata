package framework.gui;

import framework.world2d.Coordinates2D;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Screen;

public class GridGui extends Pane{
	private Rectangle[][] rec;
	private double height;
	private int n;
	
	
	public GridGui(int n) 	{		
		super();
		this.n = n;
		rec = new Rectangle[n][n];
		height = Screen.getPrimary().getVisualBounds().getHeight()/n;
	    for(int i=0; i<n; i++){
	        for(int j=0; j<n; j++){
	            rec[i][j] = new Rectangle();
	            rec[i][j].setX(i * height);
	            rec[i][j].setY(j * height);
	            rec[i][j].setWidth(height);
	            rec[i][j].setHeight(height);
	            rec[i][j].setFill(Color.BLACK);
	            rec[i][j].setStroke(Color.DARKGREY);
	            getChildren().add(rec[i][j]);
	        }
	    }
	}
	
	public void fillCell(Coordinates2D coord, Color color){
		rec[coord.getX()][coord.getY()].setFill(color);
	}
}

