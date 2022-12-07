package ua.com.studentsmarksservices.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.com.studentsmarksservices.entity.Semester;

import java.util.List;

@Repository
public interface SemesterRepository extends CrudRepository<Semester, Long> {
    List<Semester>findAll();
}
