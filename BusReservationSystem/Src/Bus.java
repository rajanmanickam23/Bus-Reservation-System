public class Bus {
    private int busId;
    private String busName;
    private int totalSeats;
    private int availableSeats;

    public Bus(int busId, String busName, int totalSeats, int availableSeats) {
        this.busId = busId;
        this.busName = busName;
        this.totalSeats = totalSeats;
        this.availableSeats = availableSeats;
    }

    public int getBusId() { return busId; }
    public String getBusName() { return busName; }
    public int getTotalSeats() { return totalSeats; }
    public int getAvailableSeats() { return availableSeats; }
}
