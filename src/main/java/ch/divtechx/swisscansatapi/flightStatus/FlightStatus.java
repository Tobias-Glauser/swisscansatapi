package ch.divtechx.swisscansatapi.flightStatus;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "flight_status")
public class FlightStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sid")
    private Long id;

    @Column(name = "status_name", nullable = false)
    private String statusName;
}
