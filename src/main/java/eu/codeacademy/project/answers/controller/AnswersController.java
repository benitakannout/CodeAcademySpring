package eu.codeacademy.project.answers.controller;


import eu.codeacademy.project.answers.dto.AnswersDto;
import eu.codeacademy.project.answers.service.AnswersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class AnswersController {

    private final AnswersService answersService;

    @GetMapping("/answers/{questionId}/update")
    public String getUserAnswers(Model model, @PathVariable("questionId") int id) {
        Optional<AnswersDto> answer = answersService.getAnswerByUserAndDay(id);
        if (answer.isPresent()) {
            model.addAttribute("answer", answer.get());
            return "/answers/answers";
        }

        return "/questions/questions";
    }
}
