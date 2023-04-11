package task.opencodetesttask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import task.opencodetesttask.entities.Answer;
import task.opencodetesttask.repository.AnswerRepository;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/answers")
public class AnswerController {

    private final AnswerRepository repository;

    @Autowired
    public AnswerController(AnswerRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Answer> getAll() {
        return repository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Answer findById(@PathVariable("id") Long id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public long create(@RequestBody Answer resource) {
        Objects.requireNonNull(resource);
        return repository.save(resource).getId();
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id") long id, @RequestBody Answer resource) {
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
