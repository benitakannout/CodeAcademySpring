package eu.codeacademy.project.answers.repository;

import eu.codeacademy.project.answers.entity.Answers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswersRepository extends JpaRepository<Answers, Integer> {
}
