package banner.example.banner;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class FirstController {


    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public String sayHello() {
        return "Hello my first controller";
    }

    @PostMapping("/post")
    public  String post (@RequestBody String message) {
        return "the request accepted and we have the following data :" + message;
    }



}
