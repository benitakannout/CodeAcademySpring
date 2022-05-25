package eu.codeacademy.project.answers.service;

import eu.codeacademy.project.answers.dto.AnswersDto;
import eu.codeacademy.project.answers.entity.Answers;
import eu.codeacademy.project.answers.mapper.AnswersMapper;
import eu.codeacademy.project.answers.repository.AnswersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    public List<AnswersDto> getAnswerByUserId(int userId) {
        return answersRepository.findAll().
                stream().
                map(mapper::mapTo).
                collect(Collectors.toList());
    }

    public AnswersDto getAnswerByUserAndDay(int dayNumber) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        List<Answers> allUserAnswers = answersRepository.findAnswersByUsername(currentPrincipalName);

        List<AnswersDto> mappedAnswers = allUserAnswers.
                stream().
                map(mapper::mapTo).
                collect(Collectors.toList());

        for (AnswersDto answer : mappedAnswers) {
            if(answer.getUser().getUsername().equals(currentPrincipalName)) {
                return answer;
            }
        }

        return null;
    }

}
