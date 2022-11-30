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
@Table(name = "subjects")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @Column(name = "subject_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "subject")
    private Set<Classes> classes = new HashSet<>();

}
