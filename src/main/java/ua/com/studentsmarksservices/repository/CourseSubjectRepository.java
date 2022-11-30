package ua.com.studentsmarksservices.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.com.studentsmarksservices.entity.CourseSubject;

@Repository
public interface CourseSubjectRepository extends CrudRepository<CourseSubject, Long> {
}
