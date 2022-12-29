package ua.com.studentsmarksservices.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
public class CreateLecturerDTO {
    @NotBlank(message = "not.blank")
    private String firstName;
    @NotBlank(message = "not.blank")
    private String lastName;
    @NotBlank(message = "not.blank")
    private String email;
    @NotBlank(message = "not.blank")
    private String password;
}
