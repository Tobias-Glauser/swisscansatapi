package ch.divtechx.swisscansatapi.flight;

import ch.divtechx.swisscansatapi.flightData.FlightDataRepository;
import ch.divtechx.swisscansatapi.flightStatus.FlightStatus;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;
    private final FlightDataRepository flightDataRepository;

    @Autowired
    public FlightServiceImpl(FlightRepository flightRepository, FlightDataRepository flightDataRepository) {
        this.flightRepository = flightRepository;
        this.flightDataRepository = flightDataRepository;
    }

    @Override
    public List<Flight> getFlights() {
        return flightRepository.findAll();
    }

    @Override
    public Flight getFlight(long flightId) {
        Optional<Flight> flightOptional = flightRepository.findById(flightId);
        if (flightOptional.isEmpty()) {
            throw new IllegalStateException("This flight id does not exist");
        }

        return flightOptional.get();
    }

    @Override
    public void addNewFlight(Flight flight) {
        Optional<Flight> flightOptional = flightRepository.findAllByFLightName(flight.getFlightName());

        if (flightOptional.isPresent()) {
            throw new IllegalStateException("This flight name already exist");
        }
        flightRepository.save(flight);
    }

    @Override
    public void deleteFlight(Long flightId) {
        boolean exist = flightRepository.existsById(flightId);

        if (!exist) {
            throw new IllegalStateException("There's no flight with id : " + flightId + " !");
        }

        flightDataRepository.deleteAllByFlightId(flightId);
        flightRepository.deleteById(flightId);
    }

    @Override
    @Transactional
    public void updateFlight(Long flightId, FlightStatus flightStatus, String flightName, LocalDateTime flightDateTime) {
        Flight flight = flightRepository.findById(flightId)
                .orElseThrow(() -> new IllegalStateException(
                        "There's no flight with id : " + flightId + " !"
                ));

        if (flightStatus != null && !Objects.equals(flightStatus, flight.getStatus())) {
            flight.setStatus(flightStatus);
        }

        if (flightName != null && flightName.length() > 0 && !Objects.equals(flight.getFlightName(), flightName)) {
            Optional<Flight> flightOptional = flightRepository
                    .findAllByFLightName(flightName);
            if (flightOptional.isPresent()) {
                throw new IllegalStateException("This flight name already exist");
            }

            flight.setFlightName(flightName);
        }

        if (flightDateTime != null && !Objects.equals(flight.getFlightDateTime(), flightDateTime)) {
            flight.setFlightDateTime(flightDateTime);
        }
    }

}
