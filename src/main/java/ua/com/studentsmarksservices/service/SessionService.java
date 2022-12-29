package ua.com.studentsmarksservices.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;
import org.springframework.stereotype.Service;
import ua.com.studentsmarksservices.entity.Session;
import ua.com.studentsmarksservices.entity.User;
import ua.com.studentsmarksservices.repository.SessionRepository;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SessionService {
    private final SessionRepository sessionRepository;

    public Session findByValue(String value) {
        return sessionRepository.findByValue(value).orElseThrow(() -> new SessionAuthenticationException("Sesja wygasła"));
    }

    public Session createSession(User user) {
        UUID uuid = UUID.randomUUID();
        Session session = Session.builder()
                .value(uuid.toString())
                .user(user)
                .build();
        return sessionRepository.save(session);
    }

    @Transactional
    public void removeSession(String value) {
        sessionRepository.deleteByValue(value);
    }

}
