package ua.com.studentsmarksservices.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
public class SemesterDTO {
    private Long semesterId;

    @NotBlank(message = "not.blank")
    private Integer year;
    @NotBlank(message = "not.blank")
    private String type;

    private boolean isOpen;
}
