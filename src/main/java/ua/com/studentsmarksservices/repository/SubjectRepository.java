package ua.com.studentsmarksservices.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.com.studentsmarksservices.entity.Subject;

import java.util.List;

@Repository
public interface SubjectRepository extends CrudRepository<Subject, Long> {
    List<Subject> findAll();
}
