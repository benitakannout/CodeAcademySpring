package eu.codeacademy.project.forum.service;

import eu.codeacademy.project.answers.dto.AnswersDto;
import eu.codeacademy.project.answers.entity.Answers;
import eu.codeacademy.project.forum.dto.PublicQuestionDto;
import eu.codeacademy.project.forum.dto.UserCommentDto;
import eu.codeacademy.project.forum.entity.PublicQuestion;
import eu.codeacademy.project.forum.entity.UserComment;
import eu.codeacademy.project.forum.mapper.PublicQuestionMapper;
import eu.codeacademy.project.forum.mapper.UserCommentMapper;
import eu.codeacademy.project.forum.repository.PublicQuestionRepository;
import eu.codeacademy.project.forum.repository.UserCommentRepository;
import eu.codeacademy.project.questions.entity.Questions;
import eu.codeacademy.project.user.entity.User;
import eu.codeacademy.project.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ForumService {

    private final PublicQuestionRepository publicQuestionRepository;
    private final PublicQuestionMapper questionMapper;
    private final UserCommentRepository userCommentRepository;
    private final UserCommentMapper commentMapper;
    private final UserRepository userRepository;

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

    @Transactional
    public void postComment(UserCommentDto comment, Principal principal, int id) {
        String username = principal.getName();
        Optional<User> user = userRepository.findUserByEmail(username);
        User userId = user.get();

        Optional<PublicQuestion> question = publicQuestionRepository.findQuestionById(id);
        PublicQuestion questionId = question.get();

        userCommentRepository.save(UserComment.builder()
                    .user(userId)
                    .question(questionId)
                    .comment(comment.getComment())
                .build());
    }
}