package eu.codeacademy.project.answers.dto;

import eu.codeacademy.project.user.entity.User;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Builder
@Getter
public class AnswersDto {

    private int id;
    private User user;
    private int day_number;
    private int difficulty;
    private int fulfillment;
    private int motivation;
    private int question;
    private String answer;

}
