package ch.divtechx.swisscansatapi.flight;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    @Query("SELECT flight FROM Flight AS flight WHERE flight.flightName = ?1")
    Optional<Flight> findAllByFLightName(String name);
}
