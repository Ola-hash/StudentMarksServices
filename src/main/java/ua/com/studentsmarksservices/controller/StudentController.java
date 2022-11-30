package ua.com.studentsmarksservices.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ua.com.studentsmarksservices.dto.StudentDTO;
import ua.com.studentsmarksservices.service.StudentService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class StudentController {

    public final StudentService studentService;

    @PostMapping("/api/student")
    public void createStudent(@RequestBody StudentDTO studentDTO) {
        studentService.createStudent(studentDTO);
    }

    @PutMapping("api/student/{studentId}")
    public void updateStudent(@Valid @RequestBody StudentDTO studentDTO, @PathVariable Long studentId) {
        studentService.updateStudent(studentDTO, studentId);
    }

    @DeleteMapping("api/student/{studentId}")
    public void deleteStudent(@PathVariable Long studentId) {
        studentService.deleteStudent(studentId);
    }

}
