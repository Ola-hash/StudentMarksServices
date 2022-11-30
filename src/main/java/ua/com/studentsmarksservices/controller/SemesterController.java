package ua.com.studentsmarksservices.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ua.com.studentsmarksservices.dto.AcademicYearDTO;
import ua.com.studentsmarksservices.service.SemesterService;

@RestController
@RequiredArgsConstructor
public class SemesterController {
    private final SemesterService semesterService;

  @PostMapping("/api/semester")
    public void createSemester(@RequestBody AcademicYearDTO academicYearDTO) {
        semesterService.createSemester(academicYearDTO);
    }
}
