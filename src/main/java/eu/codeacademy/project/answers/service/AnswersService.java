package eu.codeacademy.project.answers.service;

import eu.codeacademy.project.answers.dto.AnswersDto;
import eu.codeacademy.project.answers.entity.Answers;
import eu.codeacademy.project.answers.mapper.AnswersMapper;
import eu.codeacademy.project.answers.repository.AnswersRepository;
import eu.codeacademy.project.questions.repository.QuestionsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AnswersService {

    private final AnswersRepository answersRepository;
    private final AnswersMapper mapper;

    public Optional<AnswersDto> getAnswerByUserAndDay(int dayNumber) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        Optional<Answers> answer = answersRepository.findAnswersByUsernameAndDayNumber(currentPrincipalName, dayNumber);
        Optional<AnswersDto> answerMapped = answer.map(mapper::mapTo);
        return answerMapped;
    }

    @Transactional
    public void createAnswer(AnswersDto answer) {

        answersRepository.save(Answers.builder()
                        .difficulty(answer.getDifficulty())
                        .fulfillment(answer.getFulfillment())
                        .motivation(answer.getMotivation())
                        .answer(answer.getAnswer())
                .build());
    }

}
