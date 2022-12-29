package ua.com.studentsmarksservices.mapper;

import org.springframework.stereotype.Service;
import ua.com.studentsmarksservices.dto.PrivilegeDTO;
import ua.com.studentsmarksservices.dto.UserDetailsDTO;
import ua.com.studentsmarksservices.entity.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserDetailsMapper {
    public UserDetailsDTO mapToUserDetails(Session session) {
        User user = session.getUser();
        List<PrivilegeDTO> privileges = user.getRoles().stream().map(this::mapToPrivileges)
                .flatMap(Collection::stream)
                .toList();
        Long lecturerId = Optional.ofNullable(user.getLecturer()).map(Lecturer::getId).orElse(null);
        return UserDetailsDTO.builder()
                .id(user.getId())
                .lecturerId(lecturerId)
                .privileges(privileges)
                .sessionValue(session.getValue())
                .build();
    }

    private List<PrivilegeDTO> mapToPrivileges(Role role) {
        return role.getPrivileges().stream()
                .map(privilege -> PrivilegeDTO.builder().name(privilege.getName()).build())
                .collect(Collectors.toList());
    }
}
