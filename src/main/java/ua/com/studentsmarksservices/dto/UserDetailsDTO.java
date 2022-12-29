package ua.com.studentsmarksservices.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@Builder
public class UserDetailsDTO {
    @NotNull
    Long id;

    Long lecturerId;
    @NotNull
    String sessionValue;
    List<PrivilegeDTO> privileges;
}
