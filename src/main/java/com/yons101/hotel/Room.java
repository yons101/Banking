package com.yons101.hotel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Room {
    private int id;
    private String type;
    private int price;
    private List<Booking> bookings = new ArrayList<>();

    public Room(int id, String type, int price) {
        this.id = id;
        this.type = type;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    public boolean isAvailable(LocalDate start, LocalDate end) {
        for (Booking b : bookings) {
            // Check overlap: [start, end) vs [b.start, b.end)
            // Overlap if start < b.end && end > b.start
            if (start.isBefore(b.getEndDate()) && end.isAfter(b.getStartDate())) {
                return false;
            }
        }
        return true;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    @Override
    public String toString() {
        return "Room " + id + " (" + type + ", " + price + ")";
    }
}
