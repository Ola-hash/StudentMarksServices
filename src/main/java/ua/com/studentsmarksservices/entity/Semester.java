package ua.com.studentsmarksservices.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "semesters")
public class Semester {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "semester_id")
    private Long id;

    @Column(name = "year")
    private Integer year;

    @Column(name = "type")
    private String type;

    @Column(name = "is_open")
    private boolean isOpen;

    @OneToMany(mappedBy = "semester")
    private Set<CourseSubject> courseSubjects = new HashSet<>();

}
