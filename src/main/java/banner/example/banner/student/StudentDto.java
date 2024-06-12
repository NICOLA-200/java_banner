package banner.example.banner.student;

import jakarta.validation.constraints.NotEmpty;

public record StudentDto(
         @NotEmpty(message = "firstname should not be empty")
    String firstname,

         @NotEmpty
    String lastname,
    String email,
    Integer schoolId
        ) {

        }
