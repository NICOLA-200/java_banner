package banner.example.banner.student;


import banner.example.banner.student.StudentDto;
import banner.example.banner.student.StudentMapper;
import banner.example.banner.student.StudentRepository;
import banner.example.banner.student.StudentResponseDto;
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
