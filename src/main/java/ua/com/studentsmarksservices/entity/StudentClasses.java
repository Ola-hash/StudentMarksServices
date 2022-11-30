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
@Table(name = "students_classes")
public class StudentClasses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @Column(name = "student_classes_id")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "classes_id")
    private Classes classes;

    @OneToMany(mappedBy = "studentClasses")
    private Set<Mark> marks= new HashSet<>();
}
