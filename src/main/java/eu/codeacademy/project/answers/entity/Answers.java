package eu.codeacademy.project.answers.entity;

import eu.codeacademy.project.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Columns;
import org.springframework.web.bind.annotation.Mapping;

import javax.persistence.*;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", updatable = false, insertable = false)
    private User user;

    private int day_number;
    private int difficulty;
    private int fulfillment;
    private int motivation;

    @JoinColumn
    private int question;

    private String answer;
}
