package ua.com.studentsmarksservices.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "course_subject")
public class CourseSubject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @Column(name = "course_subject_id")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id", referencedColumnName = "course_id")
    private Course course;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "semester_id")
    private Semester semester;

    @OneToMany(mappedBy = "courseSubject")
    private Set<Classes> classes = new HashSet<>();
}
