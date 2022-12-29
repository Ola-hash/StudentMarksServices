package ua.com.studentsmarksservices.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.com.studentsmarksservices.dto.UserDetailsDTO;
import ua.com.studentsmarksservices.entity.Session;
import ua.com.studentsmarksservices.mapper.UserDetailsMapper;

@Service
@RequiredArgsConstructor
public class UserDetailsService {
    private final SessionService sessionService;
    private final UserDetailsMapper userDetailsMapper;

    public UserDetailsDTO getUserDetails(String cookieValue) {
        Session session = sessionService.findByValue(cookieValue);
        return userDetailsMapper.mapToUserDetails(session);
    }
}
