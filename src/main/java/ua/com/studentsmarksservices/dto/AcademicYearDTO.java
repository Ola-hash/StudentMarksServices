package ua.com.studentsmarksservices.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
public class AcademicYearDTO {
    @NotNull
    private Integer startYear;
    @NotNull
    private Integer endYear;
}
