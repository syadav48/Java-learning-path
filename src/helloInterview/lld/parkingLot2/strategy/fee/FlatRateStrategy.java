package helloInterview.lld.parkingLot2.strategy.fee;

import helloInterview.lld.parkingLot2.entities.ParkingTicket;

public class FlatRateStrategy implements FeeStrategy {

    private static final double RATE_PER_HOUR = 10;

    @Override
    public double calculateFee(ParkingTicket parkingTicket) {
        long parkingDuration = parkingTicket.getExitTimeStamp() - parkingTicket.getEntryTimeStamp();
        long hours = ((parkingDuration / 60*1000*60)) + 1;
        return hours*RATE_PER_HOUR;
    }
}
