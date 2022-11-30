package ua.com.studentsmarksservices.validator;

import org.springframework.stereotype.Service;
import ua.com.studentsmarksservices.dto.AcademicYearDTO;
import ua.com.studentsmarksservices.exceptions.ValidationException;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Service
public class AcademicYearValidator {
    private final static int MAX_MONTH_NUMBER = 9;

    public void validate(AcademicYearDTO academicYearDTO) {
        Date current = new Date();
        LocalDate localDate = current.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        if (academicYearDTO.getStartYear() + 1 != academicYearDTO.getEndYear()) {
            throw new ValidationException("Koniec roku akademickiego musi być większy o jedne od początku");
        }
        if (academicYearDTO.getStartYear() >= localDate.getYear() && localDate.getMonthValue() > MAX_MONTH_NUMBER) {
            throw new ValidationException("Podant rok akademicki już się rozpoczął");
        }
    }
}
