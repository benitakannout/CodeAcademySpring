package eu.codeacademy.project.answers.entity;

import eu.codeacademy.project.questions.entity.Questions;
import eu.codeacademy.project.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private int difficulty;
    private int fulfillment;
    private int motivation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", updatable = false, insertable = false)
    private Questions question;

    private String answer;
}
