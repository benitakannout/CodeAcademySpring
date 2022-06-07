package eu.codeacademy.project.forum.entity;

import eu.codeacademy.project.questions.entity.Questions;
import eu.codeacademy.project.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "public_comments")
@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question")
    private PublicQuestion question;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private String comment;

}
