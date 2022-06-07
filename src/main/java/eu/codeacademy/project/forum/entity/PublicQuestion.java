package eu.codeacademy.project.forum.entity;

import eu.codeacademy.project.answers.entity.Answers;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Table(name = "public_questions")
@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PublicQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name="id", referencedColumnName="id")
    private Set<UserComment> commentsSet;

    private String question;

}
