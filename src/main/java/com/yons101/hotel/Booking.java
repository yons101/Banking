package com.yons101.hotel;

import java.time.LocalDate;

public class Booking {
    private User user;
    private Room room;
    private LocalDate startDate;
    private LocalDate endDate;

    public Booking(User user, Room room, LocalDate startDate, LocalDate endDate) {
        this.user = user;
        this.room = room;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public User getUser() {
        return user;
    }

    public Room getRoom() {
        return room;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "user=" + user.getId() +
                ", room=" + room.getId() +
                ", start=" + startDate +
                ", end=" + endDate +
                '}';
    }
}
