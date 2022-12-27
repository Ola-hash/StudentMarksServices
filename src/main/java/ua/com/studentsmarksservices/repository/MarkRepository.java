package ua.com.studentsmarksservices.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.com.studentsmarksservices.entity.Classes;
import ua.com.studentsmarksservices.entity.Mark;

import java.util.List;

@Repository
public interface MarkRepository extends CrudRepository<Mark, Long> {
}
