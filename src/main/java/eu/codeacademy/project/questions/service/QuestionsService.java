package eu.codeacademy.project.questions.service;

import eu.codeacademy.project.questions.dto.QuestionsDto;
import eu.codeacademy.project.questions.mapper.QuestionsMapper;
import eu.codeacademy.project.questions.repository.QuestionsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuestionsService {

    private final QuestionsRepository questionsRepository1;
    private final QuestionsMapper mapper;

    public List<QuestionsDto> getQuestions() {
        return questionsRepository1.findAll().stream()
                .map(mapper::mapTo)
                .collect(Collectors.toList());
    }

}
