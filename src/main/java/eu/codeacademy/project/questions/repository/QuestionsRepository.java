package eu.codeacademy.project.questions.repository;

import eu.codeacademy.project.questions.entity.Questions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionsRepository extends JpaRepository<Questions, Long> {
}