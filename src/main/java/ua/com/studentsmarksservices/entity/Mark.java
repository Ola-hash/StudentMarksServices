package ua.com.studentsmarksservices.entity;

import lombok.*;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "marks")
public class Mark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @Column(name = "mark_id")
    private Long id;

    @Column(name = "value")
    private Integer value;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_classes_id")
    private StudentClasses studentClasses;
}
