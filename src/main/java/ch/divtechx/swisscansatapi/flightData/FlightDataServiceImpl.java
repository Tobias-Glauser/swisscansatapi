package ch.divtechx.swisscansatapi.flightData;

import ch.divtechx.swisscansatapi.flight.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

@Service
public class FlightDataServiceImpl implements FlightDataService {

    private final FlightDataRepository flightDataRepository;

    @Autowired
    public FlightDataServiceImpl(FlightDataRepository flightDataRepository) {
        this.flightDataRepository = flightDataRepository;
    }

    @Override
    public void addNewFlightData(FlightData flightData) {
        Optional<FlightData> flightDataOptional = flightDataRepository.findFlightDataByTimeStamp(flightData.getTimestamp());

        if (flightDataOptional.isPresent()) {
            throw new IllegalStateException("This flight timeStamp already exist");
        }

        flightDataRepository.save(flightData);
    }

    @Override
    public void deleteFlightData(Long flightDataId) {
        boolean exist = flightDataRepository.existsById(flightDataId);

        if (!exist) {
            throw new IllegalStateException("There's no flight data with id : " + flightDataId + " !");
        }

        flightDataRepository.deleteById(flightDataId);
    }

    @Override
    public SearchResult<FlightData> getFlightData(FlightDataSearchQuery searchQuery) {
        PageRequest page = PageRequest.of(Optional.ofNullable(searchQuery.getPage()).orElse(0), Optional.ofNullable(searchQuery.getSize()).orElse(1000));
        if (searchQuery.getFlightId() != null) {
            if (searchQuery.getTimestamp() != null) {
                return new SearchResult<>(flightDataRepository.findFlightDataByTimeStampIsAfterAndFlightId(page, searchQuery.getTimestamp(), searchQuery.getFlightId()));
            } else {
                return new SearchResult<>(flightDataRepository.findFlightDataByFlightId(page, searchQuery.getFlightId()));
            }
        } else {
            return new SearchResult<>(flightDataRepository.findAll(page));
        }
    }

    @Override
    public void updateFlightData(Long flightDataId, Flight flight, LocalDateTime timestamp, Double altitude, Double co2Measure, Double tempMeasure, String gps, Double humidityMeasure, Double airPressureMeasure) {
        FlightData flightData = flightDataRepository.findById(flightDataId)
                .orElseThrow(() -> new IllegalStateException(
                        "There's no flight data with id : \" + flightDataId + \" !"
                ));

        if (flight != null && !Objects.equals(flightData.getFlight(), flight)) {
            flightData.setFlight(flight);
        }

        if (timestamp != null && !Objects.equals(flightData.getTimestamp(), timestamp)) {
            if (flightDataRepository.findFlightDataByTimeStamp(timestamp).isPresent()) {
                throw new IllegalStateException("This flight timeStamp already exist");
            }
            flightData.setTimestamp(timestamp);
        }

        if (altitude != null && !Objects.equals(flightData.getAltitude(), altitude)) {
            flightData.setAltitude(altitude);
        }

        if (co2Measure != null && !Objects.equals(flightData.getCo2Measure(), co2Measure)) {
            flightData.setCo2Measure(co2Measure);
        }

        if (tempMeasure != null && !Objects.equals(flightData.getTempMeasure(), tempMeasure)) {
            flightData.setTempMeasure(tempMeasure);
        }

        if (gps != null && !Objects.equals(flightData.getGps(), gps)) {
            flightData.setGps(gps);
        }

        if (humidityMeasure != null && !Objects.equals(flightData.getHumidityMeasure(), humidityMeasure)) {
            flightData.setHumidityMeasure(humidityMeasure);
        }

        if (airPressureMeasure != null && !Objects.equals(flightData.getAirPressureMeasure(), airPressureMeasure)) {
            flightData.setAirPressureMeasure(airPressureMeasure);
        }
    }
}
