package gameoflife;

import java.util.ArrayList;
import java.util.List;

import framework.gui.GridGui;
import framework.gui.WorldGui;
import framework.simulation.PopulationChart;
import framework.universe2d.GridPattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;

public class GOLBuilder {

	public static WorldGui<GOLCellType> build() {
		List<GridPattern<GOLCellType>> list = new ArrayList<GridPattern<GOLCellType>>();
		list.add(new ToadPattern());
		list.add(new SingleCellPattern());

		GridGui<GOLCellType> gui = new GridGui<GOLCellType>(70, new GOLDrawer(), new GOLWorld(70, 70, new ConwaysGameOfLifeRule()), list);
        gui.setMouseListener(new SingleCellPattern());
		
		
		return gui;
	}

	public static PopulationChart<GOLCellType> buildPopulationChart() {
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setAutoRanging(true);
        xAxis.setLabel("Generation");
        yAxis.setLabel("Population");
        xAxis.setAnimated(true);
        yAxis.setAnimated(true);
        //creating the chart

        final PopulationChart<GOLCellType> chart = new PopulationChart(xAxis, yAxis, new GOLStateList());
        
		return chart;
	}

}

