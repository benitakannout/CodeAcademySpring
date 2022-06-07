package eu.codeacademy.project.forum.controller;

import eu.codeacademy.project.forum.dto.UserCommentDto;
import eu.codeacademy.project.forum.service.ForumService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequiredArgsConstructor
@RequestMapping("/forum")
public class ForumController {

    private final ForumService forumService;

    @GetMapping
    public String getPublicQuestions (Model model) {
        model.addAttribute("questions", forumService.getPublicQuestions());

        return "forum/questions";
    }

    @GetMapping("/{questionId}/view")
    public String viewQuestionComments(Model model, @PathVariable("questionId") int questionId)
    {
        model.addAttribute("comments", forumService.getCommentsByQuestionId(questionId));
        model.addAttribute("comment", UserCommentDto.builder().build());
        return "forum/question";
    }

    @PostMapping("/comment")
    public String postComment(Model model, @RequestParam("questionId") int questionId,
                                            @Valid UserCommentDto comment,
                                            BindingResult result,
                                            Principal principal){
        if (result.hasErrors()) {
            return "/error";
        }
        model.addAttribute("comment", comment);
        forumService.postComment(comment, principal, questionId);
        return "/success";
    }

}
