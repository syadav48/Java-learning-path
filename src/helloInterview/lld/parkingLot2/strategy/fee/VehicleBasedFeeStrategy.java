package helloInterview.lld.parkingLot2.strategy.fee;

import helloInterview.lld.parkingLot2.entities.ParkingTicket;
import helloInterview.lld.parkingLot2.vehicle.VehicleSize;

import java.util.Map;

public class VehicleBasedFeeStrategy implements FeeStrategy{
    private static final Map<VehicleSize, Double> HOURLY_RATES = Map.of(
            VehicleSize.SMALL, 10.0,
            VehicleSize.MEDIUM, 20.0,
            VehicleSize.LARGE, 30.0
    );

    @Override
    public double calculateFee(ParkingTicket parkingTicket) {
        long duration = parkingTicket.getExitTimeStamp() - parkingTicket.getEntryTimeStamp();
        long hours = (duration / (1000 * 60 * 60)) + 1;
        VehicleSize vehicleSize = parkingTicket.getVehicle().getVehicleSize();
        return hours * HOURLY_RATES.get(vehicleSize);
    }
}
