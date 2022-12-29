package ua.com.studentsmarksservices.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.util.WebUtils;
import ua.com.studentsmarksservices.dto.LoginRequestDTO;
import ua.com.studentsmarksservices.entity.Session;
import ua.com.studentsmarksservices.entity.User;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AuthService {
    private static final String COOKIE_NAME = "Cookie";

    private final SessionService sessionService;
    private final UserService userService;

    public void login(LoginRequestDTO loginRequestDTO, HttpServletResponse response) {
        User user = userService.findByEmailAndPassword(loginRequestDTO.getEmail(), loginRequestDTO.getPassword());
        Session session = sessionService.createSession(user);
        Cookie cookie = new Cookie(COOKIE_NAME, session.getValue());
        cookie.setMaxAge(-1);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    public void logout(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = WebUtils.getCookie(request, COOKIE_NAME);
        if (Objects.nonNull(cookie)) {
            sessionService.removeSession(cookie.getValue());
        }
        Cookie removedCookie = new Cookie(COOKIE_NAME, null);
        removedCookie.setPath("/");
        removedCookie.setMaxAge(0);
        response.addCookie(removedCookie);
    }


}
