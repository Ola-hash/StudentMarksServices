package ua.com.studentsmarksservices.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ua.com.studentsmarksservices.dto.CourseSubjectDTO;
import ua.com.studentsmarksservices.service.CourseSubjectService;

@RestController
@RequiredArgsConstructor
public class CourseSubjectController {

    public final CourseSubjectService courseSubjectService;

    @PostMapping("/api/courseSubject")
    public void createCourseSubject(@RequestBody CourseSubjectDTO courseSubjectDTO) {
        courseSubjectService.createCourseSubject(courseSubjectDTO);
    }
}
