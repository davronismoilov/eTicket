package uz.ticket.eticket.entity.ticket;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import uz.ticket.eticket.entity.base.BaseEntity;
import uz.ticket.eticket.entity.seat.SeatType;
import uz.ticket.eticket.entity.user.Passenger;

import javax.persistence.*;

@Entity
@Getter
@Setter
//@NoArgsConstructor
//@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Ticket extends BaseEntity {

    @ManyToOne
    TicketType ticketType;

    double price;
    @ManyToOne
    SeatType seatType;

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

    public Ticket() {
    }

    public Ticket(TicketType ticketType, double price, SeatType seatType, int seatNumber, long trafficId, boolean isBusy, long carriageId, Passenger passenger, Passenger childPassenger) {
        this.ticketType = ticketType;
        this.price = price;
        this.seatType = seatType;
        this.seatNumber = seatNumber;
        this.trafficId = trafficId;
        this.isBusy = isBusy;
        this.carriageId = carriageId;
        this.passenger = passenger;
        this.childPassenger = childPassenger;
    }
}
