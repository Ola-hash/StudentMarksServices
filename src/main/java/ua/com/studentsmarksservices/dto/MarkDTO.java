package ua.com.studentsmarksservices.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
public class MarkDTO {
    private Long markId;
    @NotNull
    private Long studentId;
    @NotNull
    private Long classesId;
    @NotBlank(message = "not.blank")
    private Integer value;
}
