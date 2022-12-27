package ua.com.studentsmarksservices.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ua.com.studentsmarksservices.dto.SearchStudentRequestDTO;
import ua.com.studentsmarksservices.dto.StudentDTO;
import ua.com.studentsmarksservices.dto.StudentSearchResultDTO;
import ua.com.studentsmarksservices.service.StudentClassesService;
import ua.com.studentsmarksservices.service.StudentService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {

    public final StudentService studentService;
    public final StudentClassesService studentClassesService;

    @PostMapping("/api/students")
    public void createStudent(@Valid @RequestBody StudentDTO studentDTO) {
        studentService.createStudent(studentDTO);
    }

    @PutMapping("api/students/{studentId}")
    public void updateStudent(@Valid @RequestBody StudentDTO studentDTO, @PathVariable Long studentId) {
        studentService.updateStudent(studentDTO, studentId);
    }

    @DeleteMapping("api/student/{studentId}")
    public void deleteStudent(@PathVariable Long studentId) {
        studentService.deleteStudent(studentId);
    }

    @GetMapping("api/students")
    public List<StudentDTO> getAll() {
        return studentService.getAll();
    }

    @GetMapping("api/students/{id}")
    public StudentDTO getStudentId(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @PostMapping("api/students/search")
    public List<StudentSearchResultDTO> searchStudents(@RequestBody SearchStudentRequestDTO searchStudentRequestDTO) {
        return studentService.searchStudents(searchStudentRequestDTO);
    }

    @GetMapping("api/students/{classesId}/classes")
    public List<StudentDTO> getStudents(@PathVariable Long classesId) {
        return studentClassesService.getStudents(classesId);
    }

}
