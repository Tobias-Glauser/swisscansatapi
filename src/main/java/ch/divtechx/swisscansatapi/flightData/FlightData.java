package ch.divtechx.swisscansatapi.flightData;


import ch.divtechx.swisscansatapi.flight.Flight;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "flight_data")
public class FlightData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "did")
    private Long id;

    @ManyToOne(targetEntity = Flight.class, optional = false)
    @JoinColumn(name = "fk_id_flight")
    private Flight flight;

    @Column(name = "data_timestamp", nullable = false)
    private LocalDateTime timestamp;

    @Column(name = "altitude")
    private Double altitude;

    @Column(name = "co2")
    private Double co2Measure;

    @Column(name = "temperature")
    private Double tempMeasure;

    @Column(name = "gps")
    private String gps;

    @Column(name = "humidity")
    private Double humidityMeasure;

    @Column(name = "air_pressure")
    private Double airPressureMeasure;

}
