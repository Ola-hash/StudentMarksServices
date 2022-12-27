package ua.com.studentsmarksservices.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.com.studentsmarksservices.dto.ClassesDTO;
import ua.com.studentsmarksservices.dto.ClassesSearchResultDTO;
import ua.com.studentsmarksservices.dto.SearchClassesRequestDTO;
import ua.com.studentsmarksservices.entity.*;
import ua.com.studentsmarksservices.exceptions.ValidationException;
import ua.com.studentsmarksservices.mapper.ClassesMapper;
import ua.com.studentsmarksservices.repository.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClassesService {
    private final ClassesRepository classesRepository;
    private final ClassesMapper classesMapper;
    private final LecturerRepository lecturerRepository;
    private final SubjectRepository subjectRepository;
    private final SemesterRepository semesterRepository;
    private final CourseRepository courseRepository;


    public void createClasses(ClassesDTO classesDTO) {
        Lecturer lecturer = lecturerRepository.findById(classesDTO.getLecturerId())
                .orElseThrow(() -> new ValidationException("Podany prowadzący nie istnieje"));
        Subject subject = subjectRepository.findById(classesDTO.getSubjectId())
                .orElseThrow(() -> new ValidationException("Nie istnieje podany kierunwk"));
        Course course = courseRepository.findById(classesDTO.getCourseId())
                .orElseThrow(() -> new ValidationException("Nie istnieje podany przedmiot"));
        Semester semester = semesterRepository.findById(classesDTO.getSemesterId())
                .orElseThrow(() -> new ValidationException("Nie istnieje podany semestr"));
        Classes classes = classesMapper.mapToClasses(classesDTO);
        classes.setSemester(semester);
        classes.setCourse(course);
        classes.setSubject(subject);
        classes.setLecturer(lecturer);
        classesRepository.save(classes);
    }

    public void deleteClasses(Long classesId) {
        Classes classesToDelete = classesRepository.findById(classesId)
                .orElseThrow(() -> new ValidationException("Nie znaleziono takich danych"));
        classesRepository.delete(classesToDelete);
    }

    private Predicate<Classes> filterPredicate(SearchClassesRequestDTO searchClassesRequestDTO) {
        List<Predicate<Classes>> predicates = new ArrayList<>();

        if (searchClassesRequestDTO.getSubjectId() != null) {
            predicates.add(classes -> classes.getSubject().getId().equals(searchClassesRequestDTO.getSubjectId()));
        }
        if (searchClassesRequestDTO.getCourseId() != null) {
            predicates.add(classes -> classes.getCourse().getId().equals(searchClassesRequestDTO.getCourseId()));
        }
        if (searchClassesRequestDTO.getSemesterId() != null) {
            predicates.add(classes -> classes.getSemester().getId().equals(searchClassesRequestDTO.getSemesterId()));
        }
        if (Objects.nonNull(searchClassesRequestDTO.getType())) {
            predicates.add(classes -> classes.getType().equals(searchClassesRequestDTO.getType()));
        }
        return predicates.stream().reduce(x -> true, Predicate::and);
    }

    public List<ClassesSearchResultDTO> getClasses(Long lecturerId) {
        return classesRepository.findClassesByLecturerId(lecturerId).stream().map(classes -> classesMapper.mapToClassesSearchResultDTO(classes))
                .collect(Collectors.toList());
    }

    public List<ClassesSearchResultDTO> searchClasses(SearchClassesRequestDTO searchClassesRequestDTO) {
        return classesRepository.findAll().stream()
                .filter(filterPredicate(searchClassesRequestDTO))
                .map(classesMapper::mapToClassesSearchResultDTO)
                .collect(Collectors.toList());
    }

    public ClassesSearchResultDTO getClassesDetails(Long classesId) {
        return classesRepository.findById(classesId)
                .map(classes -> classesMapper.mapToClassesSearchResultDTO(classes))
                .orElseThrow(() -> new ValidationException("Nie istnieją zajęcia o podanym id"));
    }

}

