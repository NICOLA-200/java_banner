package banner.example.banner;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class ApplicationConfig {

    @Bean
    public  MyFristClass theBean() {
        return  new MyFristClass("nice");
    }

}
