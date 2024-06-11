package banner.example.banner;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SchoolController {

    private final  SchoolRepository schoolRepository;


    public  SchoolController(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;

    }

    @PostMapping("/school")
    public SchoolDto create(
            @RequestBody SchoolDto dto
    ) {
        var school = toSchool(dto);

        schoolRepository.save(school);

  return  dto;
    }

    private  School toSchool(SchoolDto dto) {
         return new School(dto.name());
    }


    private  SchoolDto toSchoolDto(School school) {
       return  new SchoolDto(school.getName());
    }
    @GetMapping("/schools")
    public List<SchoolDto> getAllSchools() {
        return  schoolRepository.findAll()
                .stream()
                .map(this::toSchoolDto)
                .collect(Collectors.toList());
    }
}
