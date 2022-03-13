package doublr.digital.influxui;

import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InfluxUiApplication {

  public static void main(String[] args) {
    Application.launch(ChartApplication.class, args);
  }

}
