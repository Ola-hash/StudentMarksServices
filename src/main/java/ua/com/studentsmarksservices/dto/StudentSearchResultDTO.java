package ua.com.studentsmarksservices.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
public class StudentSearchResultDTO {
    @NotNull
    private Long studentId;

    private String index;
    @NotBlank(message = "not.blank")
    private String firstName;
    @NotBlank(message = "not.blank")
    private String lastName;
    @NotBlank(message = "not.blank")
    private String email;
    @NotNull
    private String subjectName;
}
