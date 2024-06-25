package n3Exercise1;

import java.util.ArrayList;

public class SeatManagement {
    private ArrayList<Seat> seats;
    
    public SeatManagement() {
        this.seats = new ArrayList<Seat>();
    }
    
    public ArrayList<Seat> getSeats() {
        return seats;
    }
    
    public String addSeat(Seat s) throws BusySeatException {
        int index = searchSeat(s.getRow(), s.getSeatNum());
        if (index == -1) {
            seats.add(s);
            return "Seat Booked Properly.";
        } else {
            throw new BusySeatException();
        }
    }
    
    public String removeSeat(int row, int seatNum) throws FreeSeatException {
        int index = searchSeat(row, seatNum);
        if (index != -1) {
            seats.remove(index);
            return "Booking Removed Properly.";
        } else {
            throw new FreeSeatException();
        }
    }
    
    public int searchSeat(int row, int seatNum) {
        int index = -1;
        
        index = seats.indexOf(seats.stream().filter(seat -> seat.getRow() == row && seat.getSeatNum() == seatNum).findFirst().orElse(null));
        return index;
    }
}
