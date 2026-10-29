package helloInterview.lld.parkingLot2.entities;

import helloInterview.lld.parkingLot2.vehicle.Vehicle;
import helloInterview.lld.parkingLot2.vehicle.VehicleSize;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class ParkingFloor {
    private final int floorNumber;
    private final Map<String, ParkingSpot> spots;

    public ParkingFloor(int floorNumber) {
        this.floorNumber = floorNumber;
        this.spots = new ConcurrentHashMap<>();
    }
    public void addSpot(ParkingSpot spot){
        spots.put(spot.getSpotId(), spot);
    }

    public synchronized Optional<ParkingSpot> findAvailableSpot(Vehicle vehicle){
        return spots.values().stream()
                .filter(spot -> !spot.isOccupied() && spot.canFitVehicle(vehicle))
                .sorted(Comparator.comparing(ParkingSpot::getSpotType))
                .findFirst();
    }

    public void displayAvailability(){
        Map<VehicleSize, Long> availableCounts = spots.values().stream()
                .filter(spot -> !spot.isOccupied())
                .collect(Collectors.groupingBy(ParkingSpot::getSpotType, Collectors.counting()));

        for (VehicleSize vehicleSize: availableCounts.keySet()){
            System.out.printf("  %s spots: %d\n", vehicleSize, availableCounts.getOrDefault(vehicleSize, 0L));
        }

    }


}
