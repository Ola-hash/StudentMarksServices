package ua.com.studentsmarksservices.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.com.studentsmarksservices.entity.StudentClasses;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentClassesRepository extends CrudRepository<StudentClasses, Long> {

    Optional<StudentClasses> findByStudentIdAndClassesId(Long studentId, Long classesId);

    List<StudentClasses> findByClassesId(Long classesId);

    List<StudentClasses> findByClassesIdAndStudentId(Long classesId, Long studentId);
}
