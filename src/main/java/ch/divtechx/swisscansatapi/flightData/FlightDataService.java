package ch.divtechx.swisscansatapi.flightData;

import ch.divtechx.swisscansatapi.flight.Flight;

import java.time.LocalDateTime;

public interface FlightDataService {
    void addNewFlightData(FlightData flightData);

    void deleteFlightData(Long flightDataId);

    SearchResult<FlightData> getFlightData(FlightDataSearchQuery searchQuery);

    void updateFlightData(Long flightDataId, Flight flight, LocalDateTime timestamp, Double altitude, Double co2Measure, Double tempMeasure, String gps, Double humidityMeasure, Double airPressureMeasure);
}
