package ua.com.studentsmarksservices.mapper;

import org.springframework.stereotype.Service;
import ua.com.studentsmarksservices.dto.MarkDTO;
import ua.com.studentsmarksservices.entity.Mark;

@Service
public class MarkMapper {
    public Mark mapToMark(MarkDTO markDTO) {
        return Mark.builder()
                .value(markDTO.getValue())
                .type(markDTO.getType()).build();
    }
}
