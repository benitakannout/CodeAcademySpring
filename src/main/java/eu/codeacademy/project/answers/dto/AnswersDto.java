package eu.codeacademy.project.answers.dto;

import com.sun.istack.NotNull;
import eu.codeacademy.project.questions.entity.Questions;
import eu.codeacademy.project.user.entity.User;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@Builder
@Getter
public class AnswersDto {

    private User user;

    @NotNull
    @Min(value = 1)
    @Max(value = 5)
    private int difficulty;

    @NotNull
    @Min(value = 1)
    @Max(value = 5)
    private int fulfillment;

    @NotNull
    @Min(value = 1)
    @Max(value = 5)
    private int motivation;

    private Questions question;

    @NotBlank
    private String answer;

}
