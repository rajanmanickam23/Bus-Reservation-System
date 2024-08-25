import java.sql.Date;

public class Booking {
    private int bookingId;
    private int userId;
    private int busId;
    private int seatsBooked;
    private Date bookingDate;

    public Booking(int bookingId, int userId, int busId, int seatsBooked, Date bookingDate) {
        this.bookingId = bookingId;
        this.userId = userId;
        this.busId = busId;
        this.seatsBooked = seatsBooked;
        this.bookingDate = bookingDate;
    }

    public int getBookingId() { return bookingId; }
    public int getUserId() { return userId; }
    public int getBusId() { return busId; }
    public int getSeatsBooked() { return seatsBooked; }
    public Date getBookingDate() { return bookingDate; }
}
