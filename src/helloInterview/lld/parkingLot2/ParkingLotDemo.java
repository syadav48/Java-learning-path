package helloInterview.lld.parkingLot2;

import helloInterview.lld.parkingLot2.entities.ParkingFloor;
import helloInterview.lld.parkingLot2.entities.ParkingSpot;
import helloInterview.lld.parkingLot2.entities.ParkingTicket;
import helloInterview.lld.parkingLot2.strategy.fee.VehicleBasedFeeStrategy;
import helloInterview.lld.parkingLot2.vehicle.*;

import java.util.Optional;

public class ParkingLotDemo {
    public static void main(String[] args) {
        ParkingLot parkingLot = ParkingLot.getInstance();
        ParkingFloor floor1 = new ParkingFloor(1);
        floor1.addSpot(new ParkingSpot("F1-S1", VehicleSize.SMALL));
        floor1.addSpot(new ParkingSpot("F1-M1", VehicleSize.MEDIUM));
        floor1.addSpot(new ParkingSpot("F1-L1", VehicleSize.LARGE));

        ParkingFloor floor2 = new ParkingFloor(2);
        floor2.addSpot(new ParkingSpot("F2-M1", VehicleSize.MEDIUM));
        floor2.addSpot(new ParkingSpot("F2-M2", VehicleSize.MEDIUM));

        parkingLot.setFeeStrategy(new VehicleBasedFeeStrategy());

        System.out.println("\n -----Vehicle ----Entries");

        floor1.displayAvailability();
        floor2.displayAvailability();

        Vehicle bike = new Bike("B-123", VehicleSize.SMALL);
        Vehicle car = new Car("C-456", VehicleSize.MEDIUM);
        Vehicle truck = new Truck("T-789", VehicleSize.LARGE);

        Optional<ParkingTicket> bikeTicketOpt = parkingLot.parkVehicle(bike);

        Optional<ParkingTicket> carTicketOpt = parkingLot.parkVehicle(car);

        Optional<ParkingTicket> truckTicketOpt = parkingLot.parkVehicle(truck);

        System.out.println("\n--- Availability after parking ---");
        floor1.displayAvailability();
        floor2.displayAvailability();

        // 3. Simulate another car entry (should go to floor 2)
        Vehicle car2 = new Car("C-999", VehicleSize.MEDIUM);
        Optional<ParkingTicket> car2TicketOpt = parkingLot.parkVehicle(car2);


        // 4. Simulate a vehicle entry that fails (no available spots)
        Vehicle bike2 = new Bike("B-000", VehicleSize.SMALL);
        Optional<ParkingTicket> failedBikeTicketOpt = parkingLot.parkVehicle(bike2);

        // 5. Simulate vehicle exits and fee calculation
        System.out.println("\n--- Vehicle Exits ---");

        if (carTicketOpt.isPresent()) {
            Optional<Double> feeOpt = parkingLot.unparkVehicle(car.getLicenseNumber());
            feeOpt.ifPresent(fee -> System.out.printf("Car C-456 unparked. Fee: $%.2f\n", fee));
        }

        System.out.println("\n--- Availability after one car leaves ---");
        floor1.displayAvailability();
        floor2.displayAvailability();

    }


}
