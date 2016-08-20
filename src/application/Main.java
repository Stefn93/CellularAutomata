package application;
	
import java.io.IOException;




import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class Main extends Application {
	
	private BorderPane root;
	
	@Override
	public void start(Stage primaryStage) {
		try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("application/SimulationGrid.fxml"));
            root = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public static Pane makeGrid(int n){
	    //double width = .SCREEN_SIZE/n;
	    Pane p = new Pane();
	    double heigth = Screen.getPrimary().getVisualBounds().getHeight();

	    Rectangle [][] rec = new Rectangle [n][n];

	    for(int i=0; i<n; i++){
	        for(int j=0; j<n; j++){
	            rec[i][j] = new Rectangle();
	            rec[i][j].setX(i * heigth);
	            rec[i][j].setY(j * heigth);
	            rec[i][j].setWidth(heigth);
	            rec[i][j].setHeight(heigth);
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
