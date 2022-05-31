package eu.codeacademy.project.answers.dto;

import eu.codeacademy.project.questions.entity.Questions;
import eu.codeacademy.project.user.entity.User;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Builder
@Getter
public class AnswersDto {

    private User user;
    private int difficulty;
    private int fulfillment;
    private int motivation;
    private Questions question;
    private String answer;

}
