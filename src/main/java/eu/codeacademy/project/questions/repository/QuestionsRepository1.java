package eu.codeacademy.project.questions.repository;

import eu.codeacademy.project.questions.entity.Questions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionsRepository1 extends JpaRepository<Questions, Long> {
}
