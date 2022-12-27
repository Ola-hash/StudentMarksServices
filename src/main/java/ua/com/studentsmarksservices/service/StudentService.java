package ua.com.studentsmarksservices.service;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import ua.com.studentsmarksservices.dto.SearchStudentRequestDTO;
import ua.com.studentsmarksservices.dto.StudentDTO;
import ua.com.studentsmarksservices.dto.StudentSearchResultDTO;
import ua.com.studentsmarksservices.entity.*;
import ua.com.studentsmarksservices.exceptions.ValidationException;
import ua.com.studentsmarksservices.mapper.StudentMapper;
import ua.com.studentsmarksservices.repository.StudentRepository;
import ua.com.studentsmarksservices.repository.SubjectRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    private final StudentMapper studentMapper;
    private final SubjectRepository subjectRepository;

    public void createStudent(StudentDTO studentDTO) {
        Subject subject = subjectRepository.findById(studentDTO.getSubjectId())
                .orElseThrow(() -> new ValidationException(("Nie znaleziono kierunku o podanym id")));
        Student student = studentMapper.mapToStudent(studentDTO, subject);
        studentRepository.save(student);
    }

    public void updateStudent(StudentDTO studentDTO, Long studentId) {
        Student studentToUpdate = studentRepository.findById(studentId)
                .orElseThrow(() -> new ValidationException("Nie znaleziono studenta o podanym id"));
        studentToUpdate.getPersonalData().setFirstName(studentDTO.getFirstName());
        studentToUpdate.getPersonalData().setLastName(studentDTO.getLastName());
        studentToUpdate.getPersonalData().setEmail(studentDTO.getEmail());
        studentMapper.mapToStudentDTO(studentRepository.save(studentToUpdate));
    }

    public void deleteStudent(Long studentId) {
        Student studentToDelete = studentRepository.findById(studentId)
                .orElseThrow(() -> new ValidationException("Nie znaleziono studenta o podanym id"));
        studentRepository.delete(studentToDelete);
    }

    public List<StudentDTO> getAll() {
        return studentRepository.findAll().stream()
                .map(student -> studentMapper.mapToStudentDTO(student))
                .collect(Collectors.toList());
    }

    public StudentDTO getStudentById(Long id) {
        return studentRepository.findById(id).map(student -> studentMapper.mapToStudentDTO(student))
                .orElseThrow(() -> new RuntimeException("Nieznaleziono studenta o podanym id"));
    }

    private Predicate<Student> filterPredicate(SearchStudentRequestDTO searchStudentRequestDTO) {
        List<Predicate<Student>> predicates = new ArrayList<>();


        if (StringUtils.isNotBlank(searchStudentRequestDTO.getLastName())) {
            predicates.add(student -> student.getPersonalData().getLastName().toUpperCase().contains(searchStudentRequestDTO.getLastName().toUpperCase()));
        }
        if (StringUtils.isNotBlank(searchStudentRequestDTO.getIndex())) {
            predicates.add(student -> student.getIndex().contains(searchStudentRequestDTO.getIndex()));
        }
        if (Objects.nonNull(searchStudentRequestDTO.getSubjectId())) {
            predicates.add(student -> Objects.equals(student.getSubject().getId(), searchStudentRequestDTO.getSubjectId()));
        }
        if (StringUtils.isNotBlank(searchStudentRequestDTO.getClassesName())) {
            predicates.add(student -> student.getStudentClasses().stream().map(StudentClasses::getClasses)
                    .map(Classes::getCode).collect(Collectors.toSet()).contains(searchStudentRequestDTO.getClassesName()));
        }
        if (StringUtils.isNotBlank(searchStudentRequestDTO.getCourseName())) {
            predicates.add(student -> student.getStudentClasses().stream().map(StudentClasses::getClasses)
                    .map(Classes::getCourse)
                    .map(Course::getName)
                    .collect(Collectors.toSet()).contains(searchStudentRequestDTO.getCourseName()));
        }

        return predicates.stream().reduce(x -> true, Predicate::and);
    }


    public List<StudentSearchResultDTO> searchStudents(SearchStudentRequestDTO searchStudentRequestDTO) {
        return studentRepository.findAll().stream()
                .filter(filterPredicate(searchStudentRequestDTO))
                .map(studentMapper::mapToStudentSearchResultDTO)
                .collect(Collectors.toList());
    }
}
