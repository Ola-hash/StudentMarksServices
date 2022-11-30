package ua.com.studentsmarksservices.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.com.studentsmarksservices.entity.Subject;

@Repository
public interface SubjectRepository extends CrudRepository<Subject, Long> {
}
