package eu.codeacademy.project.answers.entity;

import eu.codeacademy.project.questions.entity.Questions;
import eu.codeacademy.project.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.Mapping;

import javax.persistence.*;

import static org.hibernate.annotations.CascadeType.PERSIST;

@Table(name = "answer_card")
@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Answers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, nullable = false)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private int difficulty;
    private int fulfillment;
    private int motivation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question")
    private Questions question;

    private String answer;
}
