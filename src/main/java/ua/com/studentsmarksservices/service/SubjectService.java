package ua.com.studentsmarksservices.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.com.studentsmarksservices.dto.SubjectDTO;
import ua.com.studentsmarksservices.entity.Subject;
import ua.com.studentsmarksservices.exceptions.ValidationException;
import ua.com.studentsmarksservices.mapper.CourseMapper;
import ua.com.studentsmarksservices.mapper.SubjectMapper;
import ua.com.studentsmarksservices.repository.CourseRepository;
import ua.com.studentsmarksservices.repository.SubjectRepository;

@Service
@RequiredArgsConstructor
public class SubjectService {

    private final SubjectRepository subjectRepository;
    private final SubjectMapper subjectMapper;

    public void createSubject(SubjectDTO subjectDTO) {
        Subject subject = subjectMapper.mapToSubject(subjectDTO);
        subjectRepository.save(subject);
    }

    public void deleteSubject(Long subjectId) {
        Subject subjectToDelete = subjectRepository.findById(subjectId)
                .orElseThrow(() -> new ValidationException("Nie znaleziono kierunku studiów o podanym id"));
        subjectRepository.delete(subjectToDelete);
    }


}
