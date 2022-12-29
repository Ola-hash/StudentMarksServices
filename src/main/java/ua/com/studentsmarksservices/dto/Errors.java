package ua.com.studentsmarksservices.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Value;

import java.io.Serializable;
import java.util.List;

@Value
@Getter
@Builder
public class Errors implements Serializable {
    List<Error> errors;
}
