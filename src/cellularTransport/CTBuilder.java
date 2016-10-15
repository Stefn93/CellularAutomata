package cellularTransport;

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

public class CTBuilder {

	public static WorldGui<CTCellType> build() {
		List<GridPattern<CTCellType>> list = new ArrayList<GridPattern<CTCellType>>();
		list.add(new AllMoleculesPattern());
		list.add(new IonsPattern());

		GridGui<CTCellType> gui = new GridGui<CTCellType>(70, new CTDrawer(), new CTWorld(70, 70, new CellularTransportRule()), list);
        gui.setMouseListener(new IonsPattern());
		
		return gui;
	}

	public static PopulationChart<CTCellType> buildPopulationChart() {
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setAutoRanging(true);
        xAxis.setLabel("Generation");
        yAxis.setLabel("Population");
        xAxis.setAnimated(true);
        yAxis.setAnimated(true);
        //creating the chart

        final PopulationChart<CTCellType> chart = new PopulationChart(xAxis, yAxis, new CTStateList());
        
		return chart;
	}

}

