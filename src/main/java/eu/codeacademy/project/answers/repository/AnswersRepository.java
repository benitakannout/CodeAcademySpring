package eu.codeacademy.project.answers.repository;

import eu.codeacademy.project.answers.entity.Answers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnswersRepository extends JpaRepository<Answers, Integer> {

    @Query(value = "SELECT a FROM Answers a JOIN FETCH a.user WHERE a.user.email = :email")
    List<Answers> findAnswersByUsername(String email);

}
