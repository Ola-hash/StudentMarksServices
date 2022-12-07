package ua.com.studentsmarksservices.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.com.studentsmarksservices.entity.Lecturer;

import java.util.List;

@Repository
public interface LecturerRepository extends CrudRepository<Lecturer, Long> {
    List<Lecturer> findAll();
}
