package ua.com.studentsmarksservices.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.com.studentsmarksservices.entity.Classes;
import ua.com.studentsmarksservices.entity.Student;

import java.util.List;

@Repository
public interface ClassesRepository extends CrudRepository<Classes, Long> {
    List<Classes> findAll();

    List<Classes> findClassesByLecturerId(Long lecturerId);

}
