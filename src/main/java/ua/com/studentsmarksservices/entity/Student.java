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
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @Column(name = "student_id")
    private Long id;

    @Column(name = "index")
    private String index;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "personal_data_id", referencedColumnName = "personal_data_id")
    private PersonalData personalData;

    @OneToMany(mappedBy = "student")
    private Set<StudentClasses> studentClasses = new HashSet<>();
}
