package ua.com.studentsmarksservices.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
public class ClassesDTO {
    private Long classesId;

    @NotBlank(message = "not.blank")
    private String typ;
    @NotBlank(message = "not.blank")
    private String code;
    @NotBlank(message = "not.blank")
    private String classDate;
    @NotBlank(message = "not.blank")
    private String classroom;

    private Long courseSubjectId;
    private Long lecturerId;


}
