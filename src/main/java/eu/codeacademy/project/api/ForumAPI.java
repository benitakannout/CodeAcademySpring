package eu.codeacademy.project.api;

import eu.codeacademy.project.forum.dto.PublicQuestionDto;
import eu.codeacademy.project.forum.service.ForumService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
@RequiredArgsConstructor
public class ForumAPI {

    private final ForumService forumService;

    @GetMapping("/forum")
    public List<PublicQuestionDto> getAllForumQuestions() {
        return forumService.getPublicQuestions();
    }
}
