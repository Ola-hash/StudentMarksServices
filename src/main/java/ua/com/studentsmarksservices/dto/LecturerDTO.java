package ua.com.studentsmarksservices.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
public class LecturerDTO {
    private Long lecturerId;
    @NotBlank(message = "not.blank")
    private String firstName;
    @NotBlank(message = "not.blank")
    private String lastName;
    @NotBlank(message = "not.blank")
    private String email;
}
