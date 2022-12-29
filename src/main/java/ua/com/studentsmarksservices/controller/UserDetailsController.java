package ua.com.studentsmarksservices.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.WebUtils;
import ua.com.studentsmarksservices.dto.UserDetailsDTO;
import ua.com.studentsmarksservices.service.UserDetailsService;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UserDetailsController {
    private final static String COOKIE_NAME = "Cookie";
    private final UserDetailsService userDetailsService;

    @GetMapping("api/userDetails")
    public UserDetailsDTO getUserDetails(HttpServletRequest request) {
        return Optional.ofNullable(WebUtils.getCookie(request, COOKIE_NAME))
                .map(cookie -> userDetailsService.getUserDetails(cookie.getValue()))
                .orElseThrow(() -> new SessionAuthenticationException("Sesja wygasła"));

    }
}
