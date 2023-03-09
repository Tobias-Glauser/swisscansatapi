package ch.divtechx.swisscansatapi.flight;

import ch.divtechx.swisscansatapi.flightStatus.FlightStatus;
import jakarta.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.List;

public interface FlightService {
    List<Flight> getFlights();

    Flight getFlight(long flightId);

    void addNewFlight(Flight flight);

    void deleteFlight(Long flightId);

    @Transactional
    void updateFlight(Long flightId, FlightStatus flightStatus, String flightName, LocalDateTime flightDate);
}
