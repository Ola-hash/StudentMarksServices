package ua.com.studentsmarksservices.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.com.studentsmarksservices.dto.ClassesDTO;
import ua.com.studentsmarksservices.entity.Classes;
import ua.com.studentsmarksservices.entity.CourseSubject;
import ua.com.studentsmarksservices.entity.Lecturer;
import ua.com.studentsmarksservices.exceptions.ValidationException;
import ua.com.studentsmarksservices.mapper.ClassesMapper;
import ua.com.studentsmarksservices.repository.ClassesRepository;
import ua.com.studentsmarksservices.repository.CourseSubjectRepository;
import ua.com.studentsmarksservices.repository.LecturerRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClassesService {
    private final ClassesRepository classesRepository;
    private final ClassesMapper classesMapper;
    private final LecturerRepository lecturerRepository;
    private final CourseSubjectRepository courseSubjectRepository;

    public void createClasses(ClassesDTO classesDTO) {
        Lecturer lecturer = lecturerRepository.findById(classesDTO.getLecturerId())
                .orElseThrow(() -> new ValidationException("Podany prowadzący nie istnieje"));
        CourseSubject courseSubject = courseSubjectRepository.findById(classesDTO.getCourseSubjectId())
                .orElseThrow(() -> new ValidationException("Podane dane nie istnieją."));
        Classes classes = classesMapper.mapToClasses(classesDTO);
        classes.setLecturer(lecturer);
        classes.setCourseSubject(courseSubject);
        classesRepository.save(classes);
    }

    public void deleteClasses(Long classesId) {
        Classes classesToDelete = classesRepository.findById(classesId)
                .orElseThrow(() -> new ValidationException("Nie znaleziono takich danych"));
        classesRepository.delete(classesToDelete);
    }
}
