package uz.ticket.eticket.entity.base;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;

<<<<<<< HEAD
import javax.persistence.*;
=======
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
>>>>>>> origin/botirbek
import java.time.LocalDateTime;

@Data
@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @CreatedBy
    private String createdBy;
    @LastModifiedBy
    private String updatedBy;
    @CreatedDate
    private LocalDateTime createdDate;
    @LastModifiedBy
    private LocalDateTime updatedDate;
<<<<<<< HEAD
    @Column(columnDefinition = "boolean default true")
    private boolean isActive = true;
=======
    private boolean isActive;
>>>>>>> origin/botirbek

}
