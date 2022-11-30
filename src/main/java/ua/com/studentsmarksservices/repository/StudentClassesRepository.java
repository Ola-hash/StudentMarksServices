package ua.com.studentsmarksservices.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.com.studentsmarksservices.entity.StudentClasses;

@Repository
public interface StudentClassesRepository extends CrudRepository< StudentClasses,Long> {
}
