package eu.codeacademy.project.forum.repository;

import eu.codeacademy.project.forum.entity.PublicQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


public interface PublicQuestionRepository extends JpaRepository<PublicQuestion, Integer> {

    @Query(value = "SELECT q FROM PublicQuestion q WHERE q.id = :id")
    Optional<PublicQuestion> findQuestionById(int id);

}
