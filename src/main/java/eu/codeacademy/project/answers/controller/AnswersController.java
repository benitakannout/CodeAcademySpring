package eu.codeacademy.project.answers.controller;


import eu.codeacademy.project.answers.dto.AnswersDto;
import eu.codeacademy.project.answers.service.AnswersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class AnswersController {

    private final AnswersService answersService;

    @GetMapping("/answers/{questionId}/update")
    public String getUserAnswers(Model model, @PathVariable("questionId") int id,
                                 RedirectAttributes redirectAttributes) {
        Optional<AnswersDto> answer = answersService.getAnswerByUserAndDay(id);
        if (answer.isPresent()) {
            model.addAttribute("answer", answer.get());
            return "/answers/answers";
        }
        redirectAttributes.addAttribute("questionId", id);
        return "redirect:/answers/open";
    }

    @GetMapping("/answers/open")
    public String openAnswerForm(Model model, @RequestParam("questionId") int id) {
        model.addAttribute("answerCard", AnswersDto.builder().build());
        model.addAttribute("questionId", id);
        return("/answers/create");
    }

    @PostMapping("/answers/{answerId}/create")
    public String createAnswer(Model model, @RequestParam("questionId") int id, @Valid AnswersDto answer, BindingResult result, Principal principal) {
        if (result.hasErrors()) {
            return "/error";
        }
        model.addAttribute("answerCard", answer);
        answersService.createAnswer(answer, principal, id);
        return "/success";
    }
}
