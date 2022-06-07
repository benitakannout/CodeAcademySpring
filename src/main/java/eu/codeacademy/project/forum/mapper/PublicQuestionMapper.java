package eu.codeacademy.project.forum.mapper;

import eu.codeacademy.project.forum.dto.PublicQuestionDto;
import eu.codeacademy.project.forum.entity.PublicQuestion;
import org.springframework.stereotype.Component;

@Component
public class PublicQuestionMapper {

    public PublicQuestionDto mapTo(PublicQuestion question) {
        return PublicQuestionDto.builder().
                id(question.getId()).
                question(question.getQuestion()).build();
    }
}
