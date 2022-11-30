package ua.com.studentsmarksservices.entity;

import lombok.*;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "personal_data")
public class PersonalData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @Column(name = "personal_data_id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @OneToOne(mappedBy = "personalData")
    private Student student;

    @OneToOne(mappedBy = "personalData")
    private Lecturer lecturer;


}
