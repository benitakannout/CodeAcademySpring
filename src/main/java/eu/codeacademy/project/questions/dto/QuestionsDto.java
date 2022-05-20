package eu.codeacademy.project.questions.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Builder
@Getter
public class QuestionsDto {

    private int id;
    private String question;

}
