package eu.codeacademy.project.forum.repository;

import eu.codeacademy.project.forum.dto.UserCommentDto;
import eu.codeacademy.project.forum.entity.UserComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserCommentRepository extends JpaRepository<UserComment, Integer> {

    @Query(value = "SELECT c FROM UserComment c JOIN FETCH c.question WHERE c.question.id = :questionId")
    List<UserComment> findCommentsByQuestionId(int questionId);

}
