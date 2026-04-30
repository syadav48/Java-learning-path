package LLD.mbs;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Show {
    private Map<Integer, Seat> seats;
    public Show(int totalSeats){
        this.seats = new HashMap<>();
        for (int i = 0; i <= totalSeats; i++) {
            seats.put(i, new Seat(i));
        }
    }
    public void bookSeat(int ticketId){
        Seat seat = seats.get(ticketId);
        if(seat == null){
            throw new RuntimeException("Invalid Ticket");
        }
        seat.bookTicket();
    }
    public void cancelSeat(int ticketId){
        Seat seat = seats.get(ticketId);
        if(seat == null){
            throw new RuntimeException("Invalid Seat");
        }
        seat.cancelTicket();
    }
    public List<Seat> getAllAvailableSeats(){
        List<Seat> result = new ArrayList<>();
        for(Seat seat: seats.values()){
            if(seat.getStatus() == SeatStatus.Available){
                result.add(seat);
            }
        }
        return result;
    }

}
