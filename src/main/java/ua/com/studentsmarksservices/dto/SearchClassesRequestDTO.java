package ua.com.studentsmarksservices.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Value;

@Getter
@Value
@Builder
public class SearchClassesRequestDTO {
    Long subjectId;
    Long courseId;
    Long semesterId;
    String type;
}
