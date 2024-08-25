import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BusManager {
    public void addBus(Bus bus) {
        String query = "INSERT INTO buses (bus_name, total_seats, available_seats) VALUES (?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, bus.getBusName());
            statement.setInt(2, bus.getTotalSeats());
            statement.setInt(3, bus.getAvailableSeats());
            statement.executeUpdate();
            System.out.println("Bus added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Bus> getAllBuses() {
        List<Bus> buses = new ArrayList<>();
        String query = "SELECT * FROM buses";
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                Bus bus = new Bus(
                        resultSet.getInt("bus_id"),
                        resultSet.getString("bus_name"),
                        resultSet.getInt("total_seats"),
                        resultSet.getInt("available_seats")
                );
                buses.add(bus);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return buses;
    }
}
