package ua.com.studentsmarksservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import ua.com.studentsmarksservices.entity.Role;
import ua.com.studentsmarksservices.entity.User;
import ua.com.studentsmarksservices.exceptions.ValidationException;
import ua.com.studentsmarksservices.repository.RoleRepository;
import ua.com.studentsmarksservices.repository.UserRepository;

import java.util.List;

@SpringBootApplication
public class StudentsMarksServicesApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(StudentsMarksServicesApplication.class, args);
/*        UserRepository userRepository = context.getBean(UserRepository.class);
        RoleRepository roleRepository = context.getBean(RoleRepository.class);
        PasswordEncoder passwordEncoder = context.getBean(PasswordEncoder.class);
        Role role = roleRepository.findByName("ADMIN")
                .orElseThrow(() -> new ValidationException("Nie istnieje podana rola"));
        User user = User.builder()
                .password(passwordEncoder.encode("admin"))
                .roles(List.of(role))
                .email("admin@admin.pl")
                .build();
        userRepository.save(user);*/
    }

}
