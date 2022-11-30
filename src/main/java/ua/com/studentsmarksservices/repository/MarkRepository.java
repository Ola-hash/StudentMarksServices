package ua.com.studentsmarksservices.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.com.studentsmarksservices.entity.Mark;

@Repository
public interface MarkRepository extends CrudRepository<Mark, Long> {
}
