package ua.com.studentsmarksservices.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import ua.com.studentsmarksservices.dto.StudentDTO;
import ua.com.studentsmarksservices.entity.Student;
import ua.com.studentsmarksservices.exceptions.ValidationException;
import ua.com.studentsmarksservices.mapper.StudentMapper;
import ua.com.studentsmarksservices.repository.StudentRepository;

import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public void createStudent(StudentDTO studentDTO) {
        Student student = studentMapper.mapToStudent(studentDTO);
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

}
