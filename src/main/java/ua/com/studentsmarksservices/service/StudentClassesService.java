package ua.com.studentsmarksservices.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.com.studentsmarksservices.dto.StudentClassesDTO;
import ua.com.studentsmarksservices.entity.Classes;
import ua.com.studentsmarksservices.entity.Student;
import ua.com.studentsmarksservices.entity.StudentClasses;
import ua.com.studentsmarksservices.exceptions.ValidationException;
import ua.com.studentsmarksservices.repository.ClassesRepository;
import ua.com.studentsmarksservices.repository.StudentClassesRepository;
import ua.com.studentsmarksservices.repository.StudentRepository;

@Service
@RequiredArgsConstructor
public class StudentClassesService {
    private final StudentClassesRepository studentClassesRepository;
    private final StudentRepository studentRepository;
    private final ClassesRepository classesRepository;

    public void createStudentClasses(StudentClassesDTO studentClassesDTO) {
        Student student = studentRepository.findById(studentClassesDTO.getStudentId())
                .orElseThrow(() -> new ValidationException("Nie znaleziono studenta o podanym id"));
        Classes classes = classesRepository.findById(studentClassesDTO.getClassesId())
                .orElseThrow(() -> new ValidationException("Nie znaleziono zajęć o podanym id"));
        StudentClasses studentClasses = StudentClasses.builder()
                .student(student)
                .classes(classes).build();
        studentClassesRepository.save(studentClasses);
    }
    
}
