package eu.codeacademy.project.forum.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
@Builder
public class PublicQuestionDto {

    private int id;
    private String question;

}
