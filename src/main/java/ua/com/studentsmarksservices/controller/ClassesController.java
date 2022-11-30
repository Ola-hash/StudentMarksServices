package ua.com.studentsmarksservices.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ua.com.studentsmarksservices.dto.ClassesDTO;
import ua.com.studentsmarksservices.service.ClassesService;

@RestController
@RequiredArgsConstructor
public class ClassesController {

    public final ClassesService classesService;

    @PostMapping("/api/classes")
    public void createClasses(@RequestBody ClassesDTO classesDTO) {
        classesService.createClasses(classesDTO);
    }

    @DeleteMapping("api/classes/{classesId}")
    public void deleteClasses(@PathVariable Long classesId) {
        classesService.deleteClasses(classesId);
    }
}
