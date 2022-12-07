package ua.com.studentsmarksservices.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ua.com.studentsmarksservices.dto.AcademicYearDTO;
import ua.com.studentsmarksservices.dto.SemesterDTO;
import ua.com.studentsmarksservices.service.SemesterService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SemesterController {
    private final SemesterService semesterService;

    @PostMapping("/api/semester")
    public void createSemester(@RequestBody AcademicYearDTO academicYearDTO) {
        semesterService.createSemester(academicYearDTO);
    }

    @GetMapping("/api/semesters")
    public List<SemesterDTO> getAll() {
        return semesterService.getAll();
    }
}
