package eu.codeacademy.project.answers.service;

import eu.codeacademy.project.answers.dto.AnswersDto;
import eu.codeacademy.project.answers.mapper.AnswersMapper;
import eu.codeacademy.project.answers.repository.AnswersRepository;
import eu.codeacademy.project.questions.dto.QuestionsDto;
import eu.codeacademy.project.questions.mapper.QuestionsMapper;
import eu.codeacademy.project.questions.repository.QuestionsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AnswersService {

    private final AnswersRepository answersRepository;
    private final AnswersMapper mapper;

    public List<AnswersDto> getAnswers() {
        return answersRepository.findAll().stream()
                .map(mapper::mapTo)
                .collect(Collectors.toList());
    }

}
