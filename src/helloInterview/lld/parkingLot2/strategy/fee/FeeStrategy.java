package helloInterview.lld.parkingLot2.strategy.fee;

import helloInterview.lld.parkingLot2.entities.ParkingTicket;

public interface FeeStrategy {
    double calculateFee(ParkingTicket parkingTicket);
}
