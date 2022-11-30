package ua.com.studentsmarksservices.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.com.studentsmarksservices.dto.CourseSubjectDTO;
import ua.com.studentsmarksservices.entity.Course;
import ua.com.studentsmarksservices.entity.CourseSubject;
import ua.com.studentsmarksservices.entity.Semester;
import ua.com.studentsmarksservices.entity.Subject;
import ua.com.studentsmarksservices.exceptions.ValidationException;
import ua.com.studentsmarksservices.repository.CourseRepository;
import ua.com.studentsmarksservices.repository.CourseSubjectRepository;
import ua.com.studentsmarksservices.repository.SemesterRepository;
import ua.com.studentsmarksservices.repository.SubjectRepository;

@Service
@RequiredArgsConstructor
public class CourseSubjectService {

    private final CourseRepository courseRepository;
    private final SemesterRepository semesterRepository;
    private final SubjectRepository subjectRepository;
    private final CourseSubjectRepository courseSubjectRepository;

    public void createCourseSubject(CourseSubjectDTO courseSubjectDTO) {
        Subject subject = subjectRepository.findById(courseSubjectDTO.getSubjectId()).orElseThrow(() -> new ValidationException("Podany rok studiów nie istnieje"));
        Course course = courseRepository.findById(courseSubjectDTO.getCourseId()).orElseThrow(() -> new ValidationException("Podany przedmiot nie istnieje"));
        Semester semester = semesterRepository.findById(courseSubjectDTO.getSubjectId()).orElseThrow(() -> new ValidationException("Podany semestr nie istnieje"));
        CourseSubject courseSubject = CourseSubject.builder()
                .subject(subject)
                .course(course)
                .semester(semester).build();
        courseSubjectRepository.save(courseSubject);

    }
}
