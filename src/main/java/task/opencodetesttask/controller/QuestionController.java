package task.opencodetesttask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import task.opencodetesttask.entities.Question;
import task.opencodetesttask.repository.QuestionRepository;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    private final QuestionRepository repository;

    @Autowired
    public QuestionController(QuestionRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Question> getAll() {
        return repository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Question findById(@PathVariable("id") Long id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public long create(@RequestBody Question resource) {
        Objects.requireNonNull(resource);
        return repository.save(resource).getId();
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id") long id, @RequestBody Question resource) {
        Objects.requireNonNull(resource);
        resource.setId(id);
        repository.save(resource);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") long id) {
        repository.deleteById(id);
    }
}
