package eu.codeacademy.project.forum.service;

import eu.codeacademy.project.forum.dto.PublicQuestionDto;
import eu.codeacademy.project.forum.mapper.PublicQuestionMapper;
import eu.codeacademy.project.forum.repository.PublicQuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ForumService {

    private final PublicQuestionRepository publicQuestionRepository;
    private final PublicQuestionMapper questionMapper;

    public List<PublicQuestionDto> getPublicQuestions() {
        return publicQuestionRepository.findAll().stream()
                .map(questionMapper::mapTo)
                .collect(Collectors.toList());
    }
}
