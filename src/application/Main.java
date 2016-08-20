package application;
	
import java.io.IOException;





import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class Main extends Application {
	
	private GridPane root;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("SimulationGrid.fxml"));
            root = (GridPane) loader.load();
            
            root.getChildren().add(0, makeGrid(80));
            
            // Show the scene containing the root layout.
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setWidth(Screen.getPrimary().getVisualBounds().getWidth());
            primaryStage.setHeight(Screen.getPrimary().getVisualBounds().getHeight());
            primaryStage.setResizable(false);
            primaryStage.show();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public static Pane makeGrid(int n){
		
	    Pane p = new Pane();
	    Rectangle[][] rec = new Rectangle[n][n];
	    double height = Screen.getPrimary().getVisualBounds().getHeight()/n;

	    for(int i=0; i<n; i++){
	        for(int j=0; j<n; j++){
	            rec[i][j] = new Rectangle();
	            rec[i][j].setX(i * height);
	            rec[i][j].setY(j * height);
	            rec[i][j].setWidth(height);
	            rec[i][j].setHeight(height);
	            rec[i][j].setFill(null);
	            rec[i][j].setStroke(Color.BLACK);
	            p.getChildren().add(rec[i][j]);
	        }
	    }
	    return p;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
