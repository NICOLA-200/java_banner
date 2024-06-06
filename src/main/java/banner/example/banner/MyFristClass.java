package banner.example.banner;


import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


public class MyFristClass {

    private  String varc;

    public MyFristClass(String varc) {
        this.varc = varc;
    }
    public String sayHello() {
        return "Hello from the world inside!" +varc;
    }
}
