package banner.example.banner;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FirstController {

    private final StudentRepository repository;

    public FirstController(StudentRepository repository ) {
        this.repository = repository;
    }
  // student persistencing
    @PostMapping("/students")
    public  Student post (@RequestBody Student student) {
        return repository.save(student);
    }

    @GetMapping("/allStudends")
    public List<Student> findAllStudent() {
        return repository.findAll();
    }

    @GetMapping("/students/{student-name}")
    public  List<Student> findStudents(@PathVariable("student-name") String name) {
        return repository.findAllByFirstnameContaining(name);
    }

    @GetMapping("/students/search/{student-id}")
    public  Student searchStudent(@PathVariable("student-id") Integer id) {
        return repository.findById(id).orElse(null);
    }





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
