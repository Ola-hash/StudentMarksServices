package ua.com.studentsmarksservices.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Value
@Getter
@Builder
public class ClassesSearchResultDTO {
    @NotNull
    Long classesId;
    @NotBlank(message = "not.blank")
    String subjectName;
    @NotBlank(message = "not.blank")
    String courseName;
    @NotBlank(message = "not.blank")
    String type;
    @NotBlank(message = "not.blank")
    String courseDate;
    @NotBlank(message = "not.blank")
    String courseRoom;
    @NotNull
    LecturerDTO lecturerDTO;
    @NotNull
    SemesterDTO semesterDTO;
    @NotNull
    Integer numberOfStudents;


}
