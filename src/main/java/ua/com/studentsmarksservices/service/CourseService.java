package ua.com.studentsmarksservices.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.com.studentsmarksservices.dto.CourseDTO;
import ua.com.studentsmarksservices.entity.Course;
import ua.com.studentsmarksservices.exceptions.ValidationException;
import ua.com.studentsmarksservices.mapper.CourseMapper;
import ua.com.studentsmarksservices.repository.CourseRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    public void createCourse(CourseDTO courseDTO) {
        Course course = courseMapper.mapToCourse(courseDTO);
        courseRepository.save(course);
    }

    public void deleteCourse(Long courseId) {
        Course courseToDelete = courseRepository.findById(courseId)
                .orElseThrow(() -> new ValidationException("Nie znaleziono przedmiotu o podanym id"));
        courseRepository.delete(courseToDelete);
    }

    public List<CourseDTO> getAll() {
        return courseRepository.findAll().stream()
                .map(course -> courseMapper.mapToCourseDTO(course)).collect(Collectors.toList());
    }


}
