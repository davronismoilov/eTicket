package uz.ticket.eticket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import uz.ticket.eticket.file.property.FileStorageProperties;

@SpringBootApplication
@EnableConfigurationProperties(FileStorageProperties.class)
public class ETicketApplication {

    public static void main(String[] args) {
        SpringApplication.run(ETicketApplication.class, args);
    }

}
