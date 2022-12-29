package ua.com.studentsmarksservices.mapper;

import org.springframework.stereotype.Service;
import ua.com.studentsmarksservices.dto.SubjectDTO;
import ua.com.studentsmarksservices.entity.Subject;

@Service
public class SubjectMapper {

    public Subject mapToSubject(SubjectDTO subjectDTO) {
        return Subject.builder()
                .name(subjectDTO.getName())
                .build();
    }

    public SubjectDTO mapToSubjectDTO(Subject subject) {
        return SubjectDTO.builder()
                .subjectId(subject.getId())
                .name(subject.getName())
                .build();
    }
}
