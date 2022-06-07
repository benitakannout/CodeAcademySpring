package eu.codeacademy.project.questions.repository;

import eu.codeacademy.project.questions.entity.Questions;
import eu.codeacademy.project.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface QuestionsRepository extends JpaRepository<Questions, Integer> {

    @Query(value = "SELECT q FROM Questions q WHERE q.id = :id")
    Optional<Questions> findQuestionsById(int id);

}
