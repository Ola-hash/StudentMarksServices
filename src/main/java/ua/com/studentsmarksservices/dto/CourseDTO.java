package ua.com.studentsmarksservices.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
public class CourseDTO {
    private Long courseId;

    @NotBlank(message = "not.blank")
    private String name;
}
