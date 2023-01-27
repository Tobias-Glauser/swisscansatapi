package ch.divtechx.swisscansatapi.flight;

import ch.divtechx.swisscansatapi.flightStatus.FlightStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "FLIGHT")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fid")
    private Long id;

    @ManyToOne(targetEntity = FlightStatus.class, optional = false)
    @JoinColumn(name = "fk_id_status", nullable = false)
    private FlightStatus status;

    @Column(name = "flight_name", nullable = false, unique = true)
    private String flightName;

    @Column(name = "date_time", nullable = false)
    private LocalDateTime flightDateTime;


}
