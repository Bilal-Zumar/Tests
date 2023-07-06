package hotelManagement;

import java.util.Scanner;

public class HotelRegistrationProgram {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Hotel hotel = new Hotel();

        while (true) {
            printMenu();
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter guest name: ");
                    String guestName = scanner.nextLine();
                    System.out.print("Enter guest surname: ");
                    String guestSurname = scanner.nextLine();
                    hotel.registerGuest(guestName, guestSurname);
                    break;
                case 2:
                    System.out.print("Enter guest name: ");
                    String checkOutName = scanner.nextLine();
                    System.out.print("Enter guest surname: ");
                    String checkOutSurname = scanner.nextLine();
                    hotel.checkOutGuest(checkOutName, checkOutSurname);
                    break;
                case 3:
                    hotel.reviewOccupancy();
                    break;
                case 4:
                    hotel.showRoomStatus();
                    break;
                case 5:
                    System.out.println("Exiting the program. Thank you!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\nHotel Registration Program Menu:");
        System.out.println("1. Guest Registration");
        System.out.println("2. Check-out of Guest");
        System.out.println("3. Room Occupancy Review");
        System.out.println("4. History and Status of Rooms");
        System.out.println("5. Exit");
    }
}