package eu.codeacademy.project.answers.mapper;

import eu.codeacademy.project.answers.dto.AnswersDto;
import eu.codeacademy.project.answers.entity.Answers;
import org.springframework.stereotype.Component;

@Component
public class AnswersMapper {

    public AnswersDto mapTo(Answers answers) {
        return AnswersDto.builder().
                user(answers.getUser()).
                difficulty(answers.getDifficulty()).
                fulfillment(answers.getFulfillment()).
                motivation(answers.getMotivation()).
                question(answers.getQuestion()).
                answer(answers.getAnswer()).
                build();
    }
}
