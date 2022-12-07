package ua.com.studentsmarksservices.mapper;

import org.springframework.stereotype.Service;
import ua.com.studentsmarksservices.dto.LecturerDTO;
import ua.com.studentsmarksservices.entity.Lecturer;
import ua.com.studentsmarksservices.entity.PersonalData;

@Service
public class LecturerMapper {
    public Lecturer mapToLecture(LecturerDTO lecturerDTO) {
        PersonalData personalData = PersonalData.builder()
                .firstName(lecturerDTO.getFirstName())
                .lastName(lecturerDTO.getLastName())
                .email(lecturerDTO.getEmail()).build();
        return Lecturer.builder().personalData(personalData).build();
    }

    public LecturerDTO mapToLectureDTO(Lecturer lecturer) {
        return LecturerDTO.builder()
                .lecturerId(lecturer.getId())
                .firstName(lecturer.getPersonalData().getFirstName())
                .lastName(lecturer.getPersonalData().getLastName())
                .email(lecturer.getPersonalData().getEmail()).build();
    }
}
