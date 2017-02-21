package fcast.gui.controller;

import java.net.URL;
import java.util.ResourceBundle;

import fcast.simulation.SimulationThread;
import fcast.universe.world.cell.CellType;
import fcast.universe.world.cell.Pattern;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

/**
 * Controller per l'interazione con l'utente
 * 
 * @param <T>
 *            tipo di cella presente nella simulazione
 *
 */
public class SimulationController<T extends CellType> implements Initializable {

	/**
	 * Button per il restart
	 */
	@FXML
	private Button restart;
	/**
	 * Button per lo start/pause
	 */
	@FXML
	private Button start;
	/**
	 * Cursore per il delay
	 */
	@FXML
	private Slider delay;
	/**
	 * Label per mostrare la generazione corrente
	 */
	@FXML
	private Label generationLabel;
	/**
	 * Menu a tendina per la selezione del pattern da inserire con interazzione
	 */
	@FXML
	private ChoiceBox<? extends Pattern> patternChoice;
	/**
	 * Textfield con info generiche sull'automa
	 */
	@FXML
	private TextField infoTextField;
	/**
	 * VBox in cui vengono inseriti i grafici
	 */
	@FXML
	private VBox graphVBox;
	/**
	 * Button per salvataggio
	 */
	@FXML
	private Button saveButton;

	/**
	 * Simulazione
	 */
	private SimulationThread<T> simulation;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void setSimulation(SimulationThread<T> simulation) {
		this.simulation = simulation;
		this.simulation.setGuiController(this);
		ObservableList list = FXCollections.observableArrayList(simulation.getPatterns());
		patternChoice.setItems(list);
		if (patternChoice.getItems().size() > 0) {
			patternChoice.getSelectionModel().selectFirst();
			simulation.getGui().setMouseListener(patternChoice.getSelectionModel().getSelectedItem());
		}
		this.simulation.start();
	}

	@Override // This method is called by the FXMLLoader when initialization is
				// complete
	public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
		saveButton.setDisable(true);
		delayListener();
		startListener();
		restartListener();
		choiceListener();
		saveListener();
	}

	private void restartListener() {
		restart.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				simulation.reset();
			}
		});
	}

	private void startListener() {
		start.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				simulation.switchPause();
				saveButton.setDisable(!saveButton.isDisabled());
			}
		});
	}

	private void delayListener() {
		delay.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {
				simulation.setDelay(new_val.intValue());
			}
		});
	}

	private void choiceListener() {
		patternChoice.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Pattern>() {
			@Override
			public void changed(ObservableValue<? extends Pattern> ol, Pattern oldVal, Pattern newVal) {
				simulation.getGui().setMouseListener(patternChoice.getSelectionModel().getSelectedItem());
			}
		});
	}

	private void saveListener() {
		saveButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				simulation.save();
			}
		});
	}

	/**
	 * Metodo per ottenere il label della generazione
	 * 
	 * @return label della generazione
	 */
	public Label getGenerationLabel() {
		return generationLabel;
	}

	/**
	 * Metodo per settare le informazioni generiche su la simulazione
	 * 
	 * @param s
	 *            informazioni in formato Stringa
	 */
	public void setSimulationInfo(String s) {
		infoTextField.setText(s + "\n");
	}

	/**
	 * Metodo per ottenere il VBox dei grafici
	 * 
	 * @return VBox con i grafici
	 */
	public VBox getGraphVBox() {
		return graphVBox;
	}

	public void disableSave() {
		saveButton.setDisable(true);
	}

}
