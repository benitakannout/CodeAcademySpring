package eu.codeacademy.project.api;

import eu.codeacademy.project.answers.service.AnswersService;
import eu.codeacademy.project.questions.dto.QuestionsDto;
import eu.codeacademy.project.questions.service.QuestionsService;
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
public class AnswersAPI {

    private final QuestionsService questionsService;

    @GetMapping("/questions")
    public List<QuestionsDto> getAllQuestions(){
        return questionsService.getQuestions();
    }


}
