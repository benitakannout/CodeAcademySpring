package eu.codeacademy.project.answers.repository;

import eu.codeacademy.project.answers.dto.AnswersDto;
import eu.codeacademy.project.answers.entity.Answers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AnswersRepository extends JpaRepository<Answers, Integer> {

    @Query(value = "SELECT a FROM Answers a JOIN FETCH a.user WHERE a.user.email = :email AND a.day_number = :dayNumber")
    Optional<Answers> findAnswersByUsernameAndDayNumber(String email, int dayNumber);

}
