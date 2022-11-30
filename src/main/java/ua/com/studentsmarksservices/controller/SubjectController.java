package ua.com.studentsmarksservices.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ua.com.studentsmarksservices.dto.SubjectDTO;
import ua.com.studentsmarksservices.service.SubjectService;

@RestController
@RequiredArgsConstructor
public class SubjectController {
    public final SubjectService subjectService;

    @PostMapping("/api/subject")
    public void createSubject(@RequestBody SubjectDTO subjectDTO) {
        subjectService.createSubject(subjectDTO);
    }

    @DeleteMapping("api/subject/{subjectId}")
    public void deleteSubject(@PathVariable Long subjectId) {
        subjectService.deleteSubject(subjectId);
    }
}
