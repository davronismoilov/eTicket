package uz.ticket.eticket.payload;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SeatDto {
    int seatNumber;
    long carriageId;
}
