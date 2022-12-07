package ua.com.studentsmarksservices.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.com.studentsmarksservices.entity.Course;

import java.util.List;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {
    List<Course> findAll();
}
