package eu.codeacademy.project.answers.controller;


import eu.codeacademy.project.answers.service.AnswersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class AnswersController {

    private final AnswersService answersService;

    @GetMapping("/answers")
    public String getUserAnswers(Model model) {
        model.addAttribute("answer", answersService.getAnswerByUserAndDay(1));

        return "answers/answers";
    }

}
