package eu.codeacademy.project.forum.repository;

import eu.codeacademy.project.forum.entity.UserComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCommentRepository extends JpaRepository<UserComment, Integer> {
}
