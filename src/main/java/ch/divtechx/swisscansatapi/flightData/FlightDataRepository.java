package ch.divtechx.swisscansatapi.flightData;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface FlightDataRepository extends JpaRepository<FlightData, Long>, PagingAndSortingRepository<FlightData, Long> {
    @Query("SELECT flightData FROM FlightData AS flightData WHERE flightData.flight.id = ?1")
    Page<FlightData> findFlightDataByFlightId(PageRequest pageRequest, long flightId);

    @Query("SELECT flightData FROM FlightData AS flightData WHERE flightData.timeStamp > ?1 AND flightData.flight.id = ?2")
    Page<FlightData> findFlightDataByTimeStampIsAfterAndFlightId(PageRequest pageRequest, LocalDateTime timeStamp, long flightId);

    @Query("SELECT flightData FROM FlightData AS flightData WHERE flightData.timeStamp = ?1")
    Optional<FlightData> findFlightDataByTimeStamp(LocalDateTime timeStamp);

    void deleteAllByFlightId(long id);
}