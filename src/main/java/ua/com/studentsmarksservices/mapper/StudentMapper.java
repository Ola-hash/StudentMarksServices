package ua.com.studentsmarksservices.mapper;

import org.springframework.stereotype.Service;
import ua.com.studentsmarksservices.dto.StudentDTO;
import ua.com.studentsmarksservices.entity.PersonalData;
import ua.com.studentsmarksservices.entity.Student;

@Service
public class StudentMapper {
    public Student mapToStudent(StudentDTO studentDTO) {
        PersonalData personalData = PersonalData.builder()
                .firstName(studentDTO.getFirstName())
                .lastName(studentDTO.getLastName())
                .email(studentDTO.getEmail()).build();
        Student student = Student.builder()
                .index(studentDTO.getIndex())
                .personalData(personalData).build();
        personalData.setStudent(student);
        return student;
    }

    public StudentDTO mapToStudentDTO(Student student) {
        return StudentDTO.builder()
                .firstName(student.getPersonalData().getFirstName())
                .lastName(student.getPersonalData().getLastName())
                .email(student.getPersonalData().getEmail())
                .index(student.getIndex()).build();
    }
}
