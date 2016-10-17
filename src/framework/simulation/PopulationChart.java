package framework.simulation;


import framework.universe.cell.CellType;
import framework.universe.cell.StateList;
import javafx.scene.Node;
import javafx.scene.chart.Axis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.util.*;

public class PopulationChart<T extends CellType> extends LineChart<Integer, Integer>{

	private StateList<T> states;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PopulationChart(Axis xAxis, Axis yAxis, StateList<T> states) {
		super(xAxis, yAxis);
		this.states = states;
		for (CellType state:states) {
			if (!state.getValueName().equals(StateList.DEAD)) {
		        XYChart.Series series = new XYChart.Series();
		        String colorString = state.getColor().toString().replace("0x", "");
		        series.setName(state.getValueName());
		        getData().add(series);
		        series.getNode().getStyleClass().add(series.getName().replace(" ", "-"));
		        Set<Node> lineNode = this.lookupAll("."+series.getName().replace(" ", "-"));  
		        System.out.println(series.getNode().getStyleClass());
		        for (final Node line : lineNode) {  
		        	line.setStyle("-fx-stroke: #"+colorString+"; "
		        			+ "-fx-stroke-width: 2px;");  
		        }  
		        Set<Node> set = this.lookupAll("Label.chart-legend-item");
		        for (Node n:set) {
			        	Label l = (Label) n;
			        	if (l.getText().equals(series.getName())) {
			        		final Rectangle rectangle = new Rectangle(5, 5, state.getColor());
			        		System.out.println(state.getColor());
			        		l.setGraphic(rectangle);
			        	}
		        }
			}
		}
	}
	

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void updateInfo(int generation, Map<T, Integer> worldStatus) {
        //defining a series
        //populating the series with data

		Iterator<javafx.scene.chart.XYChart.Series<Integer, Integer>> it = this.getDisplayedSeriesIterator();
        while (it.hasNext()) {
        	Series actual = it.next();
        	for (CellType value:states) {
        		if(actual.getName().equals(value.getValueName()))
        			actual.getData().add(new XYChart.Data(generation, worldStatus.get(value)));
        	}
        }
        
	}

	@SuppressWarnings("unchecked")
	public void reset() {
		Iterator<javafx.scene.chart.XYChart.Series<Integer, Integer>> it = this.getDisplayedSeriesIterator();
        while (it.hasNext()) {
        	it.next().getData().clear();
        }
	}
}
