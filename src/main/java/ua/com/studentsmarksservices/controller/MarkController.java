package ua.com.studentsmarksservices.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ua.com.studentsmarksservices.dto.MarkDTO;
import ua.com.studentsmarksservices.entity.Mark;
import ua.com.studentsmarksservices.service.MarkService;

@RestController
@RequiredArgsConstructor
public class MarkController {

    private final MarkService markService;

    @PostMapping("/api/mark")
    public void addMark(@RequestBody MarkDTO markDTO) {
        markService.addMark(markDTO);
    }
}
