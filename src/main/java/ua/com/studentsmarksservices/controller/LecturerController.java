package ua.com.studentsmarksservices.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ua.com.studentsmarksservices.dto.LecturerDTO;
import ua.com.studentsmarksservices.service.LecturerService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class LecturerController {

    public final LecturerService lecturerrService;

    @PostMapping("/api/lecturer")
    public void createLecturer(@RequestBody LecturerDTO lecturerDTO) {
        lecturerrService.createLecturer(lecturerDTO);
    }

    @PutMapping("/api/lecturer/{lecturerId}")
    public void updateLecturer(@Valid @RequestBody LecturerDTO lecturerDTO, @PathVariable Long lecturerId) {
        lecturerrService.updateLecturer(lecturerDTO, lecturerId);
    }

    @DeleteMapping("api/lecturer/{lecturerId}")
    public void deleteLecturer(@PathVariable Long lecturerId) {
        lecturerrService.deleteTeacher(lecturerId);
    }
}
