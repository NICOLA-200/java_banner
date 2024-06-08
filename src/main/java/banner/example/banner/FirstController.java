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

    @PostMapping("/post-order")
    public  String post (@RequestBody Order order) {
        return "the request accepted and we have the following data :" + order.toString();
    }

    @PostMapping("/post-order-record/{sender}/{receiver}")
    public  String postRecord(@RequestBody OrderRecord order
            , @PathVariable("sender") String sender,
                              @PathVariable("receiver") String reciever,
                              @RequestParam("lastname") String lastname ) {
        return "the request accepted and we have the following data :" + order.toString() + sender + " " + reciever + " " + lastname;
    }




}
