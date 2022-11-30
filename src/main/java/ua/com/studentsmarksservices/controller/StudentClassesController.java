package ua.com.studentsmarksservices.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ua.com.studentsmarksservices.dto.CourseSubjectDTO;
import ua.com.studentsmarksservices.dto.StudentClassesDTO;
import ua.com.studentsmarksservices.service.StudentClassesService;

@RestController
@RequiredArgsConstructor
public class StudentClassesController {
    private final StudentClassesService studentClassesService;

    @PostMapping("/api/studentClasses")
    public void createStudentClasses(@RequestBody StudentClassesDTO studentClassesDTO) {
        studentClassesService.createStudentClasses(studentClassesDTO);
    }

}
