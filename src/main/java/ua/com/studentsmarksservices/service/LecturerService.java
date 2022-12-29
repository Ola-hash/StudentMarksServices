package ua.com.studentsmarksservices.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ua.com.studentsmarksservices.dto.CreateLecturerDTO;
import ua.com.studentsmarksservices.dto.LecturerDTO;
import ua.com.studentsmarksservices.entity.Lecturer;
import ua.com.studentsmarksservices.entity.Role;
import ua.com.studentsmarksservices.entity.User;
import ua.com.studentsmarksservices.exceptions.ValidationException;
import ua.com.studentsmarksservices.mapper.LecturerMapper;
import ua.com.studentsmarksservices.repository.LecturerRepository;
import ua.com.studentsmarksservices.repository.RoleRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LecturerService {
    private final static String LECTURER_ROLE_NAME = "LECTURER";

    private final LecturerRepository lecturerRepository;
    private final LecturerMapper lecturerMapper;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public void createLecturer(CreateLecturerDTO createLecturerDTO) {
        Lecturer lecturer = lecturerMapper.mapToLecture(createLecturerDTO);
        Role role = roleRepository.findByName(LECTURER_ROLE_NAME)
                .orElseThrow(() -> new ValidationException("Nie istnieje podana rola"));
        User user = User.builder()
                .email(createLecturerDTO.getEmail())
                .password(passwordEncoder.encode(createLecturerDTO.getPassword()))
                .build();
        user.setRoles(List.of(role));
        lecturer.setUser(user);
        lecturerRepository.save(lecturer);
    }

    public void updateLecturer(LecturerDTO lecturerDTO, Long lecturerId) {
        Lecturer lecturerToUpdate = lecturerRepository.findById(lecturerId).
                orElseThrow(() -> new ValidationException("Nie znaleziono Nauczyciela o podanym id."));
        lecturerToUpdate.getPersonalData().setFirstName(lecturerDTO.getLastName());
        lecturerToUpdate.getPersonalData().setLastName(lecturerDTO.getLastName());
        lecturerToUpdate.getPersonalData().setEmail(lecturerDTO.getEmail());
        lecturerMapper.mapToLectureDTO(lecturerRepository.save(lecturerToUpdate));
    }

    public void deleteTeacher(Long lecturerId) {
        Lecturer lecturerToDelete = lecturerRepository.findById(lecturerId)
                .orElseThrow(() -> new ValidationException("Nie znaleziono Nauczyciela o podanym id."));
        lecturerRepository.delete(lecturerToDelete);
    }

    public List<LecturerDTO> getAll() {
        return lecturerRepository.findAll().stream()
                .map(lecturerMapper::mapToLectureDTO)
                .sorted(Comparator.comparing(LecturerDTO::getLastName).thenComparing(LecturerDTO::getFirstName))
                .collect(Collectors.toList());
    }
}
