package task.opencodetesttask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import task.opencodetesttask.entities.Form;
import task.opencodetesttask.repository.FormRepository;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/forms")
public class FormController {

    private final FormRepository repository;

    @Autowired
    public FormController(FormRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Form> getAll() {
        return repository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Form findById(@PathVariable("id") Long id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public long create(@RequestBody Form resource) {
        Objects.requireNonNull(resource);
        return repository.save(resource).getId();
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id") long id, @RequestBody Form resource) {
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
