package LLD.mbs;

import java.util.HashMap;
import java.util.List;

public class Booking {
    public static void main(String[] args) {
        Show show = new Show(5);
        show.bookSeat(4);
        show.bookSeat(1);
        show.bookSeat(5);
        show.cancelSeat(4);
        List<Integer> list = show.getAllAvailableSeats().stream().map(Seat::getTicketId).toList();
        System.out.println(list);
    }
}
