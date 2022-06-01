package eu.codeacademy.project.answers.service;

import eu.codeacademy.project.answers.dto.AnswersDto;
import eu.codeacademy.project.answers.entity.Answers;
import eu.codeacademy.project.answers.mapper.AnswersMapper;
import eu.codeacademy.project.answers.repository.AnswersRepository;
import eu.codeacademy.project.questions.entity.Questions;
import eu.codeacademy.project.questions.repository.QuestionsRepository;
import eu.codeacademy.project.user.entity.User;
import eu.codeacademy.project.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnswersService {

    private final AnswersRepository answersRepository;
    private final AnswersMapper mapper;
    private final UserRepository userRepository;
    private final QuestionsRepository questionsRepository;

    public Optional<AnswersDto> getAnswerByUserAndDay(int question) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        Optional<Answers> answer = answersRepository.findAnswersByUsernameAndDayNumber(currentPrincipalName, question);
        Optional<AnswersDto> answerMapped = answer.map(mapper::mapTo);
        return answerMapped;
    }

    @Transactional
    public void createAnswer(AnswersDto answer, Principal principal, int id) {

        String username = principal.getName();
        Optional<User> user = userRepository.findUserByEmail(username);
        User userId = user.get();

        Optional<Questions> question = questionsRepository.findQuestionsById(id);
        Questions questionId = question.get();

        answersRepository.save(Answers.builder()
                        .user(userId)
                        .difficulty(answer.getDifficulty())
                        .fulfillment(answer.getFulfillment())
                        .motivation(answer.getMotivation())
                        .question(questionId)
                        .answer(answer.getAnswer())
                .build());
    }

}
