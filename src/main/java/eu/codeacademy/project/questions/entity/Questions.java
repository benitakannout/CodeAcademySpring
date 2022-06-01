package eu.codeacademy.project.questions.entity;

import eu.codeacademy.project.answers.entity.Answers;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Table(name = "daily_questions")
@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Questions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name="id", referencedColumnName="id")
    private Set<Answers> answersSet;

    private String question;
}
