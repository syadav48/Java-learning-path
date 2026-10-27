package helloInterview.lld.parkingLot2.strategy.parking;

import helloInterview.lld.parkingLot2.entities.ParkingFloor;
import helloInterview.lld.parkingLot2.entities.ParkingSpot;
import helloInterview.lld.parkingLot2.vehicle.Vehicle;

import java.util.List;
import java.util.Optional;

public interface ParkingStrategy {
    Optional<ParkingSpot> findSpot(List<ParkingFloor> floors, Vehicle vehicle);
}
