package dgital.doublr.influxclient;

import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

public class WebClientInfluxClient {
  private WebClient webClient;

  public WebClientInfluxClient(WebClient webClient) {
    this.webClient = webClient;
  }

  public Flux<LocationInflux> influxFor(String symbol) {
   return webClient.get()
        .uri("localhost:8080/influx/{symbol}", symbol)
        .retrieve()
        .bodyToFlux(LocationInflux.class);
  }
}
