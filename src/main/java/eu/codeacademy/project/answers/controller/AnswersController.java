package eu.codeacademy.project.answers.controller;


import eu.codeacademy.project.answers.dto.AnswersDto;
import eu.codeacademy.project.answers.entity.Answers;
import eu.codeacademy.project.answers.service.AnswersService;
import eu.codeacademy.project.questions.repository.QuestionsRepository;
import eu.codeacademy.project.questions.service.QuestionsService;
import eu.codeacademy.project.user.entity.User;
import eu.codeacademy.project.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServer;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class AnswersController {

    private final AnswersService answersService;
    private final UserService userService;
    private final QuestionsService questionsService;

    @GetMapping("/answers/{questionId}/update")
    public String getUserAnswers(Model model, @PathVariable("questionId") int id) {
        Optional<AnswersDto> answer = answersService.getAnswerByUserAndDay(id);
        if (answer.isPresent()) {
            model.addAttribute("answer", answer.get());
            return "/answers/answers";
        }

        return "redirect:/answers/open";
    }

    @GetMapping("/answers/open")
    public String openCreateAnswer(Model model) {
        model.addAttribute("answer", AnswersDto.builder().build());

        return "/answers/create";
    }


    @PostMapping("/answers/create")
    public String createAnswer(Model model, AnswersDto answer) {
        model.addAttribute("answer", answer);
        answersService.createAnswer(answer);
        return "redirect:questions/questions";
    }

}
