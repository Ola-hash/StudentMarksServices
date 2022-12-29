package ua.com.studentsmarksservices.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SearchStudentRequestDTO {
    private String index;
    private String lastName;
    private Long subjectId;
    private String classesName;
    private String courseName;
}
