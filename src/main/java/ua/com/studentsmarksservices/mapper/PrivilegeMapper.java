package ua.com.studentsmarksservices.mapper;

import lombok.Value;
import lombok.experimental.UtilityClass;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import ua.com.studentsmarksservices.entity.Privilege;

import java.util.List;
import java.util.stream.Collectors;

@Value
@UtilityClass
public class PrivilegeMapper {

    public List<GrantedAuthority> mapToGrantedAuthorities(List<Privilege> privileges) {
        return privileges.stream()
                .map(Privilege::getName)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

}
