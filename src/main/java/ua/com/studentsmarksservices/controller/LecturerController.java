package ua.com.studentsmarksservices.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ua.com.studentsmarksservices.dto.CreateLecturerDTO;
import ua.com.studentsmarksservices.dto.LecturerDTO;
import ua.com.studentsmarksservices.service.LecturerService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class LecturerController {

    public final LecturerService lecturerService;

    @PostMapping("api/lecturer")
    public void createLecturer(@Valid @RequestBody CreateLecturerDTO createLecturerDTO) {
        lecturerService.createLecturer(createLecturerDTO);
    }

    @PutMapping("/api/lecturer/{lecturerId}")
    public void updateLecturer(@Valid @RequestBody LecturerDTO lecturerDTO, @PathVariable Long lecturerId) {
        lecturerService.updateLecturer(lecturerDTO, lecturerId);
    }

    @DeleteMapping("api/lecturer/{lecturerId}")
    public void deleteLecturer(@PathVariable Long lecturerId) {
        lecturerService.deleteTeacher(lecturerId);
    }

    @GetMapping("api/lectures")
    public List<LecturerDTO> getAll() {
        return lecturerService.getAll();
    }
}

