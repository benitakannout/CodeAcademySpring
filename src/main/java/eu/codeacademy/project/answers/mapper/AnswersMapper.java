package eu.codeacademy.project.answers.mapper;

import eu.codeacademy.project.answers.dto.AnswersDto;
import eu.codeacademy.project.answers.entity.Answers;
import eu.codeacademy.project.user.entity.User;
import org.springframework.stereotype.Component;

@Component
public class AnswersMapper {

    public AnswersDto mapTo(Answers answers) {
        return AnswersDto.builder().
                id(answers.getId()).
                user(answers.getUser()).
                day_number(answers.getDay_number()).
                difficulty(answers.getDifficulty()).
                fulfillment(answers.getFulfillment()).
                motivation(answers.getMotivation()).
                question(answers.getQuestion()).
                answer(answers.getAnswer()).
                build();
    }
}
