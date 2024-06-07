package banner.example.banner;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;



@PropertySources({
        @PropertySource("classpath:custom.properties")
})
public class MyFristClass {

    private  String varc;

    @Value("Nicola")
    private  String  name;


    public MyFristClass(String varc) {
        this.varc = varc;
    }
    public String sayHello() {
        return "Hello from the world inside!" +varc +" "+ name;
    }
}
