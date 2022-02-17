//package uz.ticket.eticket.entity;
//
//import lombok.*;
//import lombok.experimental.FieldDefaults;
//
//import javax.persistence.*;
//
//@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@FieldDefaults(level = AccessLevel.PRIVATE)
//public class Ticket {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    long id;
//    @ManyToOne
//    TicketType ticketType;
//
//    double price;
//    @ManyToOne
//    Location location;
//
//    int seatNumber;
//
//    long trafficId;
//
//    boolean isBusy = false;
//
//    long carriageId;
//
//    @OneToOne
//    @Builder.Default
//    Passenger passenger = null;
//
//    @OneToOne
//    @Builder.Default
//    Passenger childPassenger = null;
//
//}
