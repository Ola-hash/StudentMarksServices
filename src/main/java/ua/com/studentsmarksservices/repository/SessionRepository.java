package ua.com.studentsmarksservices.repository;

import org.springframework.data.repository.CrudRepository;
import ua.com.studentsmarksservices.entity.Session;

import java.util.Optional;

public interface SessionRepository extends CrudRepository<Session, Long> {
    Optional<Session> findByValue(String value);

    void deleteByValue(String value);
}
