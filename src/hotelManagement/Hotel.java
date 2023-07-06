package hotelManagement;

import java.util.*;

class Hotel {
    private static final int MAX_ROOMS = 5;
    private List<HotelGuest> guests;
    private Set<Integer> occupiedRooms;

    public Hotel() {
        guests = new ArrayList<>();
        occupiedRooms = new HashSet<>();
    }

    public boolean registerGuest(String name, String surname) {
        if (guests.size() >= MAX_ROOMS) {
            System.out.println("No rooms available at the moment.");
            return false;
        }

        int roomNumber = findAvailableRoom();
        if (roomNumber == -1) {
            System.out.println("No rooms available at the moment.");
            return false;
        }

        HotelGuest guest = new HotelGuest(name, surname);
        guests.add(guest);
        occupiedRooms.add(roomNumber);
        System.out.println("Guest " + name + " " + surname + " registered in Room " + roomNumber);
        return true;
    }

    public void checkOutGuest(String name, String surname) {
        HotelGuest guest = findGuestByNameAndSurname(name, surname);
        if (guest != null) {
            guests.remove(guest);
            int roomNumber = findRoomByGuest(guest);
            occupiedRooms.remove(roomNumber);
            System.out.println("Guest " + name + " " + surname + " checked out from Room " + roomNumber);
        } else {
            System.out.println("Guest not found.");
        }
    }

    public void reviewOccupancy() {
        if (guests.isEmpty()) {
            System.out.println("No guests currently staying in the hotel.");
        } else {
            System.out.println("Occupied Rooms:");
            for (HotelGuest guest : guests) {
                int roomNumber = findRoomByGuest(guest);
                System.out.println("Room " + roomNumber + ": " + guest.getName() + " " + guest.getSurname());
            }
        }
    }

    public void showRoomStatus() {
        System.out.println("Room Status:");
        for (int roomNumber = 1; roomNumber <= MAX_ROOMS; roomNumber++) {
            String status = occupiedRooms.contains(roomNumber) ? "Occupied" : "Available";
            System.out.println("Room " + roomNumber + ": " + status);
        }
    }

    private int findAvailableRoom() {
        for (int roomNumber = 1; roomNumber <= MAX_ROOMS; roomNumber++) {
            if (!occupiedRooms.contains(roomNumber)) {
                return roomNumber;
            }
        }
        return -1;
    }

    private HotelGuest findGuestByNameAndSurname(String name, String surname) {
        for (HotelGuest guest : guests) {
            if (guest.getName().equals(name) && guest.getSurname().equals(surname)) {
                return guest;
            }
        }
        return null;
    }

    private int findRoomByGuest(HotelGuest guest) {
        int roomNumber = 1;
        for (HotelGuest g : guests) {
            if (g == guest) {
                return roomNumber;
            }
            roomNumber++;
        }
        return -1;
    }
}
