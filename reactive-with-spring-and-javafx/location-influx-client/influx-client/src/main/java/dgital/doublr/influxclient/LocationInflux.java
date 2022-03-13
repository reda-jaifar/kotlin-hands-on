package dgital.doublr.influxclient;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class LocationInflux {
  private String symbol;
  private Integer count;
  private LocalDateTime time;
}
