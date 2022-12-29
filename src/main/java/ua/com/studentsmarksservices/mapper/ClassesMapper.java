package ua.com.studentsmarksservices.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.com.studentsmarksservices.dto.ClassesDTO;
import ua.com.studentsmarksservices.dto.ClassesSearchResultDTO;
import ua.com.studentsmarksservices.dto.SemesterDTO;
import ua.com.studentsmarksservices.entity.Classes;

@Service
@RequiredArgsConstructor
public class ClassesMapper {
    private final LecturerMapper lecturerMapper;
    private final SemesterMapper semesterMapper;

    public Classes mapToClasses(ClassesDTO classesDTO) {
        return Classes.builder()
                .type(classesDTO.getType())
                .code(classesDTO.getCode())
                .classDate(classesDTO.getClassesDate())
                .classroom(classesDTO.getClassesRoom())
                .build();
    }

    public ClassesDTO mapToClassesDTO(Classes classes) {
        return ClassesDTO.builder()
                .type(classes.getType())
                .code(classes.getCode())
                .classesDate(classes.getClassDate())
                .classesRoom(classes.getClassroom())
                .courseName(classes.getCourse().getName())
                .subjectName(classes.getSubject().getName())
                .lecturerId(classes.getLecturer().getId())
                .courseId(classes.getCourse().getId())
                .subjectId(classes.getSubject().getId())
                .semesterId(classes.getSemester().getId())
                .classesId(classes.getId())
                .classesRoom(classes.getClassroom())
                .build();
    }


    public ClassesSearchResultDTO mapToClassesSearchResultDTO(Classes classes) {
        return ClassesSearchResultDTO.builder()
                .subjectName(classes.getSubject().getName())
                .courseName(classes.getCourse().getName())
                .courseDate(classes.getClassDate())
                .type(classes.getType())
                .lecturerDTO(lecturerMapper.mapToLectureDTO(classes.getLecturer()))
                .semesterDTO(semesterMapper.mapToSemesterDTO(classes.getSemester()))
                .classesId(classes.getId())
                .numberOfStudents(classes.getStudentClasses().size())
                .courseRoom(classes.getClassroom())
                .build();
    }
}
