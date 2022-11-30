package ua.com.studentsmarksservices.entity;


import lombok.*;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @Column(name = "course_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToOne(mappedBy = "course")
    private Classes classes;


}
