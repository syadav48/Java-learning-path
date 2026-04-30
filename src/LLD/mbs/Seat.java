package LLD.mbs;

public class Seat {
    private int ticketId;
    private SeatStatus status;

      public Seat(int ticketId){
        this.ticketId = ticketId;
        this.status = SeatStatus.Available;
    }

    public int getTicketId() {
        return ticketId;
    }

    public SeatStatus getStatus() {
        return status;
    }

    public void bookTicket(){
          if(this.status == SeatStatus.Booked){
              throw new RuntimeException("Ticket Already Booked");
          }
          this.status = SeatStatus.Booked;
    }
    public void cancelTicket(){
          this.status = SeatStatus.Available;
    }
}
