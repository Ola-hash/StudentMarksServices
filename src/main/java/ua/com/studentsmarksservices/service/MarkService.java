package ua.com.studentsmarksservices.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.com.studentsmarksservices.dto.MarkDTO;
import ua.com.studentsmarksservices.entity.Mark;
import ua.com.studentsmarksservices.entity.StudentClasses;
import ua.com.studentsmarksservices.exceptions.ValidationException;
import ua.com.studentsmarksservices.mapper.MarkMapper;
import ua.com.studentsmarksservices.repository.MarkRepository;
import ua.com.studentsmarksservices.repository.StudentClassesRepository;

@Service
@RequiredArgsConstructor
public class MarkService {
    private final MarkRepository markRepository;
    private final MarkMapper markMapper;
    private final StudentClassesRepository studentClassesRepository;


    public void addMark(MarkDTO markDTO) {

        StudentClasses studentClasses = studentClassesRepository.findByStudentIdAndClassesId(markDTO.getStudentId(), markDTO.getClassesId())
                .orElseThrow(() -> new ValidationException("Nie znaleziono podanych danych"));
        Mark mark = markMapper.mapToMark(markDTO);
        mark.setStudentClasses(studentClasses);
        markRepository.save(mark);

    }
}
