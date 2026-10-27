package helloInterview.lld.parkingLot2.strategy.parking;

import helloInterview.lld.parkingLot2.entities.ParkingFloor;
import helloInterview.lld.parkingLot2.entities.ParkingSpot;
import helloInterview.lld.parkingLot2.vehicle.Vehicle;

import java.util.List;
import java.util.Optional;

public class BestFitStrategy implements ParkingStrategy{

    @Override
    public Optional<ParkingSpot> findSpot(List<ParkingFloor> floors, Vehicle vehicle) {
        Optional<ParkingSpot> bestSpot = Optional.empty();
        for (ParkingFloor floor: floors){
            Optional<ParkingSpot> spotOnThisFloor = floor.findAvailableSpot(vehicle);
            if(spotOnThisFloor.isPresent()){
                if(bestSpot.isEmpty()){
                    bestSpot = spotOnThisFloor;
                } else {
                    //For a car, both MEDIUM and LARGE may be valid, but MEDIUM is a better fit
                    // because it wastes less space.
                    if(spotOnThisFloor.get().getSpotType().ordinal() < bestSpot.get().getSpotType().ordinal()){
                        bestSpot = spotOnThisFloor;
                    }
                }

            }
        }
        return bestSpot;
    }
}
