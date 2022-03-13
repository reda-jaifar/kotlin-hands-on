package doublr.digital.influxui;

import dgital.doublr.influxclient.LocationInflux;
import dgital.doublr.influxclient.WebClientInfluxClient;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class ChartController implements Consumer<LocationInflux> {

  @FXML
  private LineChart<String, Integer> chart;
  private ObservableList<XYChart.Data<String, Integer>> seriesData = FXCollections.observableArrayList();
  private WebClientInfluxClient influxClient;

  public ChartController(WebClientInfluxClient influxClient) {
    this.influxClient = influxClient;
  }

  @FXML
  public void initialize() {
    ObservableList<XYChart.Series<String, Integer>> data = FXCollections.observableArrayList();
    data.add(new XYChart.Series<>(seriesData));
    chart.setData(data);

    String symbol = "PARIS";
    influxClient.influxFor(symbol).subscribe(this);
  }

  @Override
  public void accept(LocationInflux locationInflux) {
    Platform.runLater(() ->
        seriesData.add(new XYChart.Data<>(String.valueOf(locationInflux.getTime().getSecond()),
            locationInflux.getCount()))
    );
  }
}
