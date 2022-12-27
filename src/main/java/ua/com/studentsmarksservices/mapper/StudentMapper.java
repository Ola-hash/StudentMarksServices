package ua.com.studentsmarksservices.mapper;

import org.springframework.stereotype.Service;
import ua.com.studentsmarksservices.dto.StudentDTO;
import ua.com.studentsmarksservices.dto.StudentSearchResultDTO;
import ua.com.studentsmarksservices.entity.PersonalData;
import ua.com.studentsmarksservices.entity.Student;
import ua.com.studentsmarksservices.entity.Subject;

@Service
public class StudentMapper {
    public Student mapToStudent(StudentDTO studentDTO, Subject subject) {
        PersonalData personalData = PersonalData.builder()
                .firstName(studentDTO.getFirstName())
                .lastName(studentDTO.getLastName())
                .email(studentDTO.getEmail()).build();
        Student student = Student.builder()
                .subject(subject)
                .index(studentDTO.getIndex())
                .personalData(personalData).build();
        personalData.setStudent(student);
        return student;
    }

    public StudentDTO mapToStudentDTO(Student student) {
        return StudentDTO.builder()
                .subjectId(student.getSubject().getId())
                .studentId(student.getId())
                .firstName(student.getPersonalData().getFirstName())
                .lastName(student.getPersonalData().getLastName())
                .email(student.getPersonalData().getEmail())
                .index(student.getIndex())
                .build();
    }

    public StudentSearchResultDTO mapToStudentSearchResultDTO(Student student) {
        return StudentSearchResultDTO.builder()
                .subjectName(student.getSubject().getName())
                .studentId(student.getId())
                .firstName(student.getPersonalData().getFirstName())
                .lastName(student.getPersonalData().getLastName())
                .email(student.getPersonalData().getEmail())
                .index(student.getIndex())
                .build();
    }
}
