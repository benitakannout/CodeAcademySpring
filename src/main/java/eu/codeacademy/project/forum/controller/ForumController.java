package eu.codeacademy.project.forum.controller;

import eu.codeacademy.project.forum.service.ForumService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
