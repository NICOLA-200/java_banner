package banner.example.banner.student;

import banner.example.banner.*;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class StudentController {


    private  final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    // student persistencing
    @PostMapping("/students")
    public StudentResponseDto saveStudent(@Valid  @RequestBody StudentDto dto) {

     return  this.studentService.saveStudent(dto);

    }



    @GetMapping("/allStudends")
    public List<Student> findAllStudent() {
        return studentService.getAllStudent();
    }

    @GetMapping("/students/{student-name}")
    public  List<Student> findStudents(@PathVariable("student-name") String name) {
        return studentService.findStudents(name);
    }


    @GetMapping("/students/search/{student-id}")
    public  Student searchStudent(@PathVariable("student-id") Integer id) {

        return studentService.searchStudent(id);
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
