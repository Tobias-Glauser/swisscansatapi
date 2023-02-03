package ch.divtechx.swisscansatapi.flight;

import ch.divtechx.swisscansatapi.flightStatus.FlightStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(path = "flight")
public class FlightController {

    private final FlightService flightService;

    @Autowired
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping
    public List<Flight> getFlight() {
        return flightService.getFlights();
    }

    @PostMapping
    public void addNewFlight(@RequestBody Flight flight) {
        flightService.addNewFlight(flight);
    }

    @DeleteMapping(path = "{flightId}")
    public void deleteFlight(@PathVariable("flightId") long flightId) {
        flightService.deleteFlight(flightId);
    }

    @PutMapping(path = "{flightId}")
    public void updateFlight(
            @PathVariable("flightId") long flightId,
            @RequestParam(required = false) FlightStatus flightStatus,
            @RequestParam(required = false) String flightName,
            @RequestParam(required = false) LocalDateTime flightDateTime) {
        flightService.updateFlight(flightId, flightStatus, flightName, flightDateTime);
    }

}
