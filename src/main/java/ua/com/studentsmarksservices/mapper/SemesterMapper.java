package ua.com.studentsmarksservices.mapper;

import org.springframework.stereotype.Service;
import ua.com.studentsmarksservices.dto.SemesterDTO;
import ua.com.studentsmarksservices.entity.Semester;

@Service
public class SemesterMapper {

    public SemesterDTO mapToSemesterDTO(Semester semester) {
        return SemesterDTO.builder()
                .year(semester.getYear())
                .type(semester.getType())
                .isOpen(semester.isOpen()).build();
    }

}
