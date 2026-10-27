package helloInterview.lld.parkingLot2.entities;

import helloInterview.lld.parkingLot2.vehicle.Vehicle;
import helloInterview.lld.parkingLot2.vehicle.VehicleSize;

public class ParkingSpot {
    private final String spotId;
    private boolean isOccupied;
    private Vehicle parkedVehicle;
    private final VehicleSize spotType;

    public ParkingSpot(String spotId, VehicleSize spotType) {
        this.spotId = spotId;
        this.spotType = spotType;
        this.isOccupied = false;
        this.parkedVehicle = null;
    }

    public VehicleSize getSpotType() {
        return spotType;
    }

    public String getSpotId() {
        return spotId;
    }
    public boolean isOccupied(){
        return isOccupied;
    }
    public void parkVehicle(Vehicle vehicle){
        this.parkedVehicle = vehicle;
        this.isOccupied = true;
    }
    public void unParkVehicle(){
        this.parkedVehicle = null;
        this.isOccupied = false;
    }
    public boolean canFitVehicle(Vehicle vehicle){
        if(isOccupied) return false;
        return switch (vehicle.getVehicleSize()) {
            case SMALL -> spotType == VehicleSize.SMALL;
            case MEDIUM -> spotType == VehicleSize.MEDIUM;
            case LARGE -> spotType == VehicleSize.LARGE;
            default -> false;
        };
    }

}
