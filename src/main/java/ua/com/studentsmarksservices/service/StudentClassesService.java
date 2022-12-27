package ua.com.studentsmarksservices.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.com.studentsmarksservices.dto.StudentClassesDTO;
import ua.com.studentsmarksservices.dto.StudentDTO;
import ua.com.studentsmarksservices.entity.Classes;
import ua.com.studentsmarksservices.entity.Student;
import ua.com.studentsmarksservices.entity.StudentClasses;
import ua.com.studentsmarksservices.exceptions.ValidationException;
import ua.com.studentsmarksservices.mapper.StudentMapper;
import ua.com.studentsmarksservices.repository.ClassesRepository;
import ua.com.studentsmarksservices.repository.StudentClassesRepository;
import ua.com.studentsmarksservices.repository.StudentRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentClassesService {
    private final StudentClassesRepository studentClassesRepository;
    private final StudentRepository studentRepository;
    private final ClassesRepository classesRepository;
    private final StudentMapper studentMapper;

    public void createStudentClasses(StudentClassesDTO studentClassesDTO) {
        Student student = studentRepository.findById(studentClassesDTO.getStudentId())
                .orElseThrow(() -> new ValidationException("Nie znaleziono studenta o podanym id"));
        Classes classes = classesRepository.findById(studentClassesDTO.getClassesId())
                .orElseThrow(() -> new ValidationException("Nie znaleziono zajęć o podanym id"));
        Optional<StudentClasses> studentClassesOptional = studentClassesRepository.findByStudentIdAndClassesId(studentClassesDTO.getStudentId(), studentClassesDTO.getClassesId());
        if (studentClassesOptional.isPresent()) {
            throw new ValidationException("Student jest już przypisany do zajęć");
        }
        StudentClasses studentClasses = StudentClasses.builder()
                .student(student)
                .classes(classes).build();
        studentClassesRepository.save(studentClasses);
    }

    public List<StudentDTO> getStudents(Long classesId) {
        return studentClassesRepository.findByClassesId(classesId).stream()
                .map(studentClasses -> studentClasses.getStudent())
                .map(student -> studentMapper.mapToStudentDTO(student))
                .collect(Collectors.toList());

    }
}
