package task.opencodetesttask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import task.opencodetesttask.entities.Form;
import task.opencodetesttask.entities.Question;
import task.opencodetesttask.repository.FormRepository;
import task.opencodetesttask.repository.QuestionRepository;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("questions/{formId}/questions")
public class QuestionsByFormController {

    private final FormRepository repository;

    @Autowired
    public QuestionsByFormController(FormRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Set<Question> getAllQuestionsByFormId(@PathVariable("formId") long id) throws ClassNotFoundException {
        Optional<Form> requiredQuestion = repository.findById(id);
        if (requiredQuestion.isPresent()) {
            return requiredQuestion.get().getQuestions();
        } else {
            throw new ClassNotFoundException();
        }
    }
}
