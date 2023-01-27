package ch.divtechx.swisscansatapi.flightData;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FlightDataSearchQuery {
    private LocalDateTime timestamp;
    private Long flightId;
    private Integer page;
    private Integer size;
}
