package uz.ticket.eticket.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity

@FieldDefaults(level = AccessLevel.PRIVATE)
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @ManyToOne
    TicketType ticketType;

    double price;
    @ManyToOne
    Location location;

    int seatNumber;

    long trafficId;

    boolean isBusy = false;

    long carriageId;

    @OneToOne
    @Builder.Default
    Passenger passenger = null;

    @OneToOne
    @Builder.Default
    Passenger childPassenger = null;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public long getTrafficId() {
        return trafficId;
    }

    public void setTrafficId(long trafficId) {
        this.trafficId = trafficId;
    }

    public boolean isBusy() {
        return isBusy;
    }

    public void setBusy(boolean busy) {
        isBusy = busy;
    }

    public long getCarriageId() {
        return carriageId;
    }

    public void setCarriageId(long carriageId) {
        this.carriageId = carriageId;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Passenger getChildPassenger() {
        return childPassenger;
    }

    public void setChildPassenger(Passenger childPassenger) {
        this.childPassenger = childPassenger;
    }
}
