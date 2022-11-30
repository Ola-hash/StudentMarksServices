package ua.com.studentsmarksservices.mapper;

import org.springframework.stereotype.Service;
import ua.com.studentsmarksservices.dto.ClassesDTO;
import ua.com.studentsmarksservices.entity.Classes;

@Service
public class ClassesMapper {

    public Classes mapToClasses(ClassesDTO classesDTO) {
        return Classes.builder()
                .type(classesDTO.getTyp())
                .code(classesDTO.getCode())
                .classDate(classesDTO.getClassDate())
                .classroom(classesDTO.getClassroom())
                .build();
    }
}
