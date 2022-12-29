package ua.com.studentsmarksservices.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ua.com.studentsmarksservices.dto.ClassesDTO;
import ua.com.studentsmarksservices.dto.ClassesSearchResultDTO;
import ua.com.studentsmarksservices.dto.SearchClassesRequestDTO;
import ua.com.studentsmarksservices.service.ClassesService;

import java.util.List;

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

    @PostMapping("api/classes/search")
    public List<ClassesSearchResultDTO> searchClasses(@RequestBody SearchClassesRequestDTO searchClassesRequestDTO) {
        return classesService.searchClasses(searchClassesRequestDTO);
    }

    @GetMapping("api/classes/{lecturerId}")
    public List<ClassesSearchResultDTO> getClassesByLecturerId(@PathVariable Long lecturerId) {
        return classesService.getClasses(lecturerId);
    }

    @GetMapping("api/classes/{classesId}/details")
    public ClassesSearchResultDTO getClassesDetails(@PathVariable Long classesId) {
        return classesService.getClassesDetails(classesId);
    }
}
