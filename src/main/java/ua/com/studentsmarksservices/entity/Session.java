package ua.com.studentsmarksservices.entity;

import lombok.*;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "sessions")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "session_id")
    private Long id;

    @Column(unique = true)
    private String value;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
