package ua.com.studentsmarksservices.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
public class MarkDTO {
    private Long markId;

    private Long studentClassesId;

    @NotBlank(message = "not.blank")
    private Integer value;
    @NotBlank(message = "not.blank")
    private String type;


}
