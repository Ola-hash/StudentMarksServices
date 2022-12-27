package ua.com.studentsmarksservices.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
public class ClassesDTO {
    private Long classesId;

    @NotBlank(message = "not.blank")
    private String type;
    @NotBlank(message = "not.blank")
    private String code;
    @NotBlank(message = "not.blank")
    private String classesDate;
    @NotBlank(message = "not.blank")
    private String classesRoom;
    @NonNull
    private Long courseId;
    @NonNull
    private Long lecturerId;
    @NonNull
    private Long subjectId;
    @NonNull
    private Long semesterId;

    private String courseName;
    private String subjectName;

}
