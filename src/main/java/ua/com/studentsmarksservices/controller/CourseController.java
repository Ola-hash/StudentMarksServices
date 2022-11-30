package ua.com.studentsmarksservices.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ua.com.studentsmarksservices.dto.CourseDTO;
import ua.com.studentsmarksservices.service.CourseService;

@RestController
@RequiredArgsConstructor
public class CourseController {

    public final CourseService courseService;

    @PostMapping("/api/course")
    public void createCourse(@RequestBody CourseDTO courseDTO) {
        courseService.createCourse(courseDTO);
    }

    @DeleteMapping("api/course/{courseId}")
    public void deleteCourse(@PathVariable Long courseId) {
        courseService.deleteCourse(courseId);
    }
}
