package ua.com.studentsmarksservices.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.com.studentsmarksservices.dto.LecturerDTO;
import ua.com.studentsmarksservices.entity.Lecturer;
import ua.com.studentsmarksservices.exceptions.ValidationException;
import ua.com.studentsmarksservices.mapper.LecturerMapper;
import ua.com.studentsmarksservices.repository.LecturerRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LecturerService {
    private final LecturerRepository lecturerRepository;
    private final LecturerMapper lecturerMapper;

    public void createLecturer(LecturerDTO lecturerDTO) {
        Lecturer lecturer = lecturerMapper.mapToLecture(lecturerDTO);
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

    public List<LecturerDTO> getAll(){
        return lecturerRepository.findAll().stream()
                .map(lecturer -> lecturerMapper.mapToLectureDTO(lecturer)).collect(Collectors.toList());
    }
}
