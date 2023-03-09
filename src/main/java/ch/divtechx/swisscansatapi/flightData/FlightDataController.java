package ch.divtechx.swisscansatapi.flightData;

import ch.divtechx.swisscansatapi.flight.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping(path = "flightdata")
public class FlightDataController {
    private final FlightDataService flightDataService;

    @Autowired
    public FlightDataController(FlightDataService flightDataService) {
        this.flightDataService = flightDataService;
    }

    @GetMapping
    public SearchResult<FlightData> getFlightData(FlightDataSearchQuery searchQuery) {
        return flightDataService.getFlightData(searchQuery);
    }
    @GetMapping(path = "lowest-altitude")
    public int getLowestAltitude (long flightId) {
        return flightDataService.getLowestAltitude(flightId);
    }

    @PostMapping
    public void addNewFlight(@RequestBody FlightData flightData) {
        flightDataService.addNewFlightData(flightData);
    }

    @DeleteMapping(path = "{flightDataId}")
    public void deleteFlight(@PathVariable("flightDataId") long flightId) {
        flightDataService.deleteFlightData(flightId);
    }

    @PutMapping(path = "{flightDataId}")
    public void updateFlight(
            @PathVariable("flightDataId") long flightDataId,
            @RequestParam(required = false) Flight flight,
            @RequestParam(required = false) LocalDateTime timestamp,
            @RequestParam(required = false) Double altitude,
            @RequestParam(required = false) Double co2Measure,
            @RequestParam(required = false) Double tempMeasure,
            @RequestParam(required = false) String gps,
            @RequestParam(required = false) Double humidityMeasure,
            @RequestParam(required = false) Double airPressureMeasure) {
        flightDataService.updateFlightData(flightDataId, flight, timestamp, altitude, co2Measure, tempMeasure, gps, humidityMeasure, airPressureMeasure);
    }

}
