package helloInterview.lld.parkingLot2.strategy.parking;

import helloInterview.lld.parkingLot2.entities.ParkingFloor;
import helloInterview.lld.parkingLot2.entities.ParkingSpot;
import helloInterview.lld.parkingLot2.vehicle.Vehicle;

import java.util.List;
import java.util.Optional;

public class NearestFirstStrategy implements ParkingStrategy{
    @Override
    public Optional<ParkingSpot> findSpot(List<ParkingFloor> floors, Vehicle vehicle) {
        for (ParkingFloor floor: floors){
            Optional<ParkingSpot> spot = floor.findAvailableSpot(vehicle);
            if(spot.isPresent()){
                return spot;
            }
        }
        return Optional.empty();
    }
}
