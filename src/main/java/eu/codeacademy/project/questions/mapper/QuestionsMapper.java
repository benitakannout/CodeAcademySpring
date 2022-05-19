package eu.codeacademy.project.questions.mapper;

import eu.codeacademy.project.questions.dto.QuestionsDto;
import eu.codeacademy.project.questions.entity.Questions;
import org.springframework.stereotype.Component;

@Component
public class QuestionsMapper {

    public QuestionsDto mapTo(Questions questions) {
        return QuestionsDto.builder().
                id(questions.getId()).
                question(questions.getQuestion()).build();
    }
}
