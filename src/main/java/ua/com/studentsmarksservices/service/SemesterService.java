package ua.com.studentsmarksservices.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.com.studentsmarksservices.dto.AcademicYearDTO;
import ua.com.studentsmarksservices.dto.SemesterDTO;
import ua.com.studentsmarksservices.entity.Semester;
import ua.com.studentsmarksservices.mapper.SemesterMapper;
import ua.com.studentsmarksservices.repository.SemesterRepository;
import ua.com.studentsmarksservices.validator.AcademicYearValidator;
import ua.com.studentsmarksservices.validator.SemesterValidator;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SemesterService {
    private final static String SUMMER_SEMESTER = "letni";
    private final static String WINTER_SEMESTER = "zimowy";

    private final SemesterRepository semesterRepository;
    private final AcademicYearValidator academicYearValidator;
    private final SemesterMapper semesterMapper;

    public void createSemester(AcademicYearDTO academicYearDTO) {
        academicYearValidator.validate(academicYearDTO);
        Semester summerSemester = buildSemester(academicYearDTO.getEndYear(), SUMMER_SEMESTER);
        Semester winterSemester = buildSemester(academicYearDTO.getStartYear(), WINTER_SEMESTER);
        semesterRepository.save(summerSemester);
        semesterRepository.save(winterSemester);
    }

    private Semester buildSemester(Integer year, String type) {
        return Semester.builder()
                .isOpen(true)
                .year(year)
                .type(type)
                .build();
    }

    public List<SemesterDTO> getAll() {
        return semesterRepository.findAll().stream()
                .filter(semester -> semester.isOpen())
                .map(semester -> semesterMapper.mapToSemesterDTO(semester)).collect(Collectors.toList());
    }
}
