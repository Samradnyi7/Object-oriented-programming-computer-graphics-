import java.util.Scanner;

public class Hotel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int FLOORS = 3;
        final int ROOMS = 5;
        // false = available, true = booked
        boolean[][] hotelRooms = new boolean[FLOORS][ROOMS];

        int choice;
        do {
            System.out.println("\n--- Hotel Room Booking System ---");
            System.out.println("1. View Room Status");
            System.out.println("2. Book a Room");
            System.out.println("3. Exit");
            System.out.print("Enter your choice (1-3): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewRooms(hotelRooms);
                    break;
                case 2:
                    bookRoom(hotelRooms, scanner);
                    break;
                case 3:
                    System.out.println("Thank you for using the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please select 1 to 3.");
            }
        } while (choice != 3);

        scanner.close();
    }

    // Method to view all rooms
    public static void viewRooms(boolean[][] rooms) {
        System.out.println("\nRoom Status (A = Available, B = Booked):");
        for (int i = 0; i < rooms.length; i++) {
            System.out.print("Floor " + (i + 1) + ": ");
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j]) {
                    System.out.print("[B] ");
                } else {
                    System.out.print("[A] ");
                }
            }
            System.out.println();
        }
    }

    // Method to book a room
    public static void bookRoom(boolean[][] rooms, Scanner scanner) {
        System.out.print("Enter floor number (1-" + rooms.length + "): ");
        int floor = scanner.nextInt();
        System.out.print("Enter room number (1-" + rooms[0].length + "): ");
        int room = scanner.nextInt();

        // Check for valid input
        if (floor < 1 || floor > rooms.length || room < 1 || room > rooms.length) {
            System.out.println("Invalid floor or room number. Try again.");
            return;
        }

        // Check if already booked
        if (rooms[floor - 1][room - 1]) {
            System.out.println("Sorry, that room is already booked.");
        } else {
            rooms[floor - 1][room - 1] = true;
            System.out.println("Room " + room + " on Floor " + floor + " booked successfully!");
        }
    }
}
