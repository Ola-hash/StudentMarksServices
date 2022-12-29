package ua.com.studentsmarksservices.mapper;

import org.springframework.stereotype.Service;
import ua.com.studentsmarksservices.dto.CourseDTO;
import ua.com.studentsmarksservices.entity.Course;

@Service
public class CourseMapper {

    public Course mapToCourse(CourseDTO courseDTO) {
        return Course.builder()
                .id(courseDTO.getCourseId())
                .name(courseDTO.getName())
                .build();
    }

    public CourseDTO mapToCourseDTO(Course course) {
        return CourseDTO.builder()
                .courseId(course.getId())
                .name(course.getName())
                .build();
    }
}
