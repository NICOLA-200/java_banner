package banner.example.banner;


import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class StudentService
{
    private final StudentRepository repository;
    private  final StudentMapper studentMapper;

    public StudentService(StudentRepository repository, StudentMapper studentMapper) {
        this.repository = repository;
        this.studentMapper = studentMapper;
    }

    public StudentResponseDto saveStudent(
          StudentDto dto
    ) {
        var student = studentMapper.toStudent(dto);
        var savedStudent = repository.save(student);
        return studentMapper.tostudentResponseDto(savedStudent);
    }

    public List<Student> getAllStudent() {
        return   repository.findAll();

    }

    public  List<Student> findStudents(@PathVariable("student-name") String name) {
        return repository.findAllByFirstnameContaining(name);
    }

    public  Student searchStudent(@PathVariable("student-id") Integer id) {

        return repository.findById(id).orElse(null);
    }

}
