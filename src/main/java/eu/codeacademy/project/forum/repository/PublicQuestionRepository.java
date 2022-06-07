package eu.codeacademy.project.forum.repository;

import eu.codeacademy.project.forum.entity.PublicQuestion;
import eu.codeacademy.project.questions.entity.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PublicQuestionRepository extends JpaRepository<PublicQuestion, Integer> {

    @Query("SELECT q FROM PublicQuestion q WHERE q.id = :id")
    Optional<Questions> findPublicQuestionById(int id);

}
