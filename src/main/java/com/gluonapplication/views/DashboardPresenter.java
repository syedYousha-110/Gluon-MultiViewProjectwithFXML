package com.gluonapplication.views;


import com.gluonhq.charm.glisten.animation.BounceInRightTransition;
import com.gluonhq.charm.glisten.application.AppManager;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.control.FloatingActionButton;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;


public class DashboardPresenter{
    @FXML
    private View dashboard;
    @FXML
    private AreaChart<String,Number> AreaChart;
    @FXML
    private AnchorPane chart_pane;

    @FXML
    private TextField Search;

    @FXML
    private Button btn_areaChart;

    @FXML
    private Button btn_barChart;

    @FXML
    private Button btn_lineChart;

    @FXML
    private Button btn_pieChart;

    @FXML
    private Button btn_scatterChart;
    @FXML
    private HBox root;

    @FXML
    private AnchorPane side_ankerPane;


    public void initialize() {
        dashboard.setShowTransitionFactory(BounceInRightTransition::new);
        FloatingActionButton fb = new FloatingActionButton(MaterialDesignIcon.BACKSPACE.text, e->{
            AppManager.getInstance().switchToPreviousView();
        });
        fb.showOn(dashboard);
        dashboard.showingProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue){
                AppBar appBar = AppManager.getInstance().getAppBar();
                appBar.setTitle(new Label("dashBoard"));
                appBar.setNavIcon(MaterialDesignIcon.MENU.button(e->{AppManager.getInstance().getDrawer().open();}));
            }
        });
        //setAreaChart();

    }
  public void setAreaChart(){
      btn_areaChart.setOnAction(event -> {
          this.AreaChart.getCreateSymbols();
          AreaChart.setAnimated(true);
          AreaChart.setBackground(Background.fill(Color.ALICEBLUE));
      });
      NumberAxis xAxis = new NumberAxis();
      xAxis.setLabel("Revenue per employee");

      NumberAxis yAxis = new NumberAxis();
      yAxis.setLabel("No of employees");

      this.AreaChart = new AreaChart(xAxis,yAxis);
      XYChart.Series dataSeries1 = new XYChart.Series<>();
      dataSeries1.setName("2014");

      dataSeries1.getData().add(new XYChart.Data<>(1000L, 1));
      dataSeries1.getData().add(new XYChart.Data<>(2000L, 3));
      dataSeries1.getData().add(new XYChart.Data<>(20000L, 4));
      dataSeries1.getData().add(new XYChart.Data<>(3000L, 5));
      dataSeries1.getData().add(new XYChart.Data<>(40000L, 6));
      dataSeries1.getData().add(new XYChart.Data<>(500000L, 7));
      dataSeries1.getData().add(new XYChart.Data<>(60000L, 8));
      dataSeries1.getData().add(new XYChart.Data<>(7000000L, 9));
      dataSeries1.getData().add(new XYChart.Data<>(800000L, 10));
      dataSeries1.getData().add(new XYChart.Data<>(9000000L, 11));
      dataSeries1.getData().add(new XYChart.Data<>(10000000L, 12));

      dataSeries1.setName("Revenue");
     this.AreaChart.getData().addAll(dataSeries1);
    chart_pane.getChildren().add(this.AreaChart);


    }

}
