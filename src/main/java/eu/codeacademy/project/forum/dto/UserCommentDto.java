package eu.codeacademy.project.forum.dto;

import eu.codeacademy.project.forum.entity.PublicQuestion;
import eu.codeacademy.project.user.entity.User;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Builder
@Getter
public class UserCommentDto {

    private PublicQuestion question;
    private User user;
    private String comment;

}
