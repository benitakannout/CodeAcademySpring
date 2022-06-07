package eu.codeacademy.project.forum.service;

import eu.codeacademy.project.forum.dto.PublicQuestionDto;
import eu.codeacademy.project.forum.dto.UserCommentDto;
import eu.codeacademy.project.forum.mapper.PublicQuestionMapper;
import eu.codeacademy.project.forum.mapper.UserCommentMapper;
import eu.codeacademy.project.forum.repository.PublicQuestionRepository;
import eu.codeacademy.project.forum.repository.UserCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ForumService {

    private final PublicQuestionRepository publicQuestionRepository;
    private final PublicQuestionMapper questionMapper;
    private final UserCommentRepository userCommentRepository;
    private final UserCommentMapper commentMapper;

    public List<PublicQuestionDto> getPublicQuestions() {
        return publicQuestionRepository.findAll().stream()
                .map(questionMapper::mapTo)
                .collect(Collectors.toList());
    }

    public List<UserCommentDto> getCommentsByQuestionId(int questionId){
        if (!userCommentRepository.findCommentsByQuestionId(questionId).isEmpty()){
            return userCommentRepository.findCommentsByQuestionId(questionId).stream()
                    .map(commentMapper::mapTo)
                    .collect(Collectors.toList());
        }
        return null;
    }
}
