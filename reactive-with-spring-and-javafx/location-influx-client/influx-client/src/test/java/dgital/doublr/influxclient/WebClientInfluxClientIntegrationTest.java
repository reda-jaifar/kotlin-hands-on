package dgital.doublr.influxclient;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

class WebClientInfluxClientIntegrationTest {
  private WebClient webClient = WebClient.builder().build();

  @Test
  void shouldWork() {
    WebClientInfluxClient webClientInfluxClient = new WebClientInfluxClient(webClient);
    String symbol = "PARIS";
    Flux<LocationInflux> influxes = webClientInfluxClient.influxFor(symbol);

    Assertions.assertEquals(5, influxes.take(5).count().block());


  }
}