package eu.codeacademy.project.forum.mapper;

import eu.codeacademy.project.forum.dto.UserCommentDto;
import eu.codeacademy.project.forum.entity.UserComment;
import org.springframework.stereotype.Component;

@Component
public class UserCommentMapper {

    public UserCommentDto mapTo(UserComment comment) {
        return UserCommentDto.builder().
                id(comment.getId()).
                question(comment.getQuestion()).
                user(comment.getUser()).
                comment(comment.getComment()).build();
    }

}
