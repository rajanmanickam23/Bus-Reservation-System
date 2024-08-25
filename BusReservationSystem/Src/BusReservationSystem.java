import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class BusReservationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserManager userManager = new UserManager();
        BusManager busManager = new BusManager();
        BookingManager bookingManager = new BookingManager();

        while (true) {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Add Bus");
            System.out.println("4. View Buses");
            System.out.println("5. Make Booking");
            System.out.println("6. View Bookings");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    userManager.registerUser(new User(0, username, password));
                    break;

                case 2:
                    System.out.print("Enter username: ");
                    username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    password = scanner.nextLine();
                    if (userManager.login(username, password)) {
                        System.out.println("Login successful!");
                    } else {
                        System.out.println("Invalid username or password.");
                    }
                    break;

                case 3:
                    System.out.print("Enter bus name: ");
                    String busName = scanner.nextLine();
                    System.out.print("Enter total seats: ");
                    int totalSeats = scanner.nextInt();
                    System.out.print("Enter available seats: ");
                    int availableSeats = scanner.nextInt();
                    busManager.addBus(new Bus(0, busName, totalSeats, availableSeats));
                    break;

                case 4:
                    List<Bus> buses = busManager.getAllBuses();
                    for (Bus bus : buses) {
                        System.out.println("Bus ID: " + bus.getBusId() + ", Name: " + bus.getBusName() +
                                ", Total Seats: " + bus.getTotalSeats() + ", Available Seats: " + bus.getAvailableSeats());
                    }
                    break;

                case 5:
                    System.out.print("Enter user ID (for simplicity, hardcoded as 1): ");
                    int userId = scanner.nextInt(); 
                    System.out.print("Enter bus ID: ");
                    int busId = scanner.nextInt();
                    System.out.print("Enter seats to book: ");
                    int seatsBooked = scanner.nextInt();
                    Date bookingDate = new Date(System.currentTimeMillis());
                    bookingManager.makeBooking(new Booking(0, userId, busId, seatsBooked, bookingDate));
                    break;

                case 6:
                    System.out.print("Enter user ID to view bookings: ");
                    userId = scanner.nextInt();
                    List<Booking> bookings = bookingManager.getBookingsByUser(userId);
                    for (Booking booking : bookings) {
                        System.out.println("Booking ID: " + booking.getBookingId() +
                                ", Bus ID: " + booking.getBusId() + ", Seats Booked: " + booking.getSeatsBooked() +
                                ", Booking Date: " + booking.getBookingDate());
                    }
                    break;

                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
