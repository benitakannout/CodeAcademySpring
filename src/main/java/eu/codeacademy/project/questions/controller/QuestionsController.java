package eu.codeacademy.project.questions.controller;

import eu.codeacademy.project.answers.service.AnswersService;
import eu.codeacademy.project.questions.service.QuestionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/questions")
public class QuestionsController {

    private final QuestionsService questionsService;

    @GetMapping
    public String getQuestions (Model model) {
        model.addAttribute("questions", questionsService.getQuestions());

        return "questions/questions";
    }

}
