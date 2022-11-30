package ua.com.studentsmarksservices.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.com.studentsmarksservices.entity.Classes;

@Repository
public interface ClassesRepository extends CrudRepository<Classes, Long> {
}
