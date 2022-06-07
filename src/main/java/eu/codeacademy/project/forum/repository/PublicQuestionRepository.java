package eu.codeacademy.project.forum.repository;

import eu.codeacademy.project.forum.entity.PublicQuestion;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PublicQuestionRepository extends JpaRepository<PublicQuestion, Integer> {

}
