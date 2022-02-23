package uz.ticket.eticket.util;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;

@Configuration
public class BeanUtils {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

//    @Bean
//    @Primary
//    public ObjectMapper objectMapper(Jackson2ObjectMapperBuilder builder) {
//        System.out.println("Config is starting.");
//        ObjectMapper objectMapper = builder.createXmlMapper(false).build();
//        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
//        return objectMapper;
//    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean
    public SimpleDateFormat simpleDateFormat(){
        return new SimpleDateFormat();
    }



}
