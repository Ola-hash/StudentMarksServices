package ua.com.studentsmarksservices.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Value;

import javax.validation.constraints.NotBlank;

@Value
@Getter
@Builder
public class PrivilegeDTO {
    @NotBlank
    String name;
}
