import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookingManager {
    public void makeBooking(Booking booking) {
        String query = "INSERT INTO bookings (user_id, bus_id, seats_booked, booking_date) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, booking.getUserId());
            statement.setInt(2, booking.getBusId());
            statement.setInt(3, booking.getSeatsBooked());
            statement.setDate(4, booking.getBookingDate());
            statement.executeUpdate();
            System.out.println("Booking made successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Booking> getBookingsByUser(int userId) {
        List<Booking> bookings = new ArrayList<>();
        String query = "SELECT * FROM bookings WHERE user_id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Booking booking = new Booking(
                        resultSet.getInt("booking_id"),
                        resultSet.getInt("user_id"),
                        resultSet.getInt("bus_id"),
                        resultSet.getInt("seats_booked"),
                        resultSet.getDate("booking_date")
                );
                bookings.add(booking);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookings;
    }
}
