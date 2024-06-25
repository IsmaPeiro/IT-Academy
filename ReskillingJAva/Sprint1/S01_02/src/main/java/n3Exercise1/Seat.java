package n3Exercise1;

import java.util.Objects;

public class Seat {
    private final int row;
    private final int seatNum;
    private final String person;

    public Seat(int row, int seatNum, String person) {
        this.row = row;
        this.seatNum = seatNum;
        this.person = person;
    }

    public int getRow() {
        return row;
    }

    public int getSeatNum() {
        return seatNum;
    }

    public String getPerson() {
        return person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seat seat = (Seat) o;
        return getRow() == seat.getRow() && getSeatNum() == seat.getSeatNum();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRow(), getSeatNum());
    }

    @Override
    public String toString() {
        return "Fila:" + row +", Asiento=" + seatNum +", persona=" + person;
    }
}
