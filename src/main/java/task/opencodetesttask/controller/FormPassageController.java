package task.opencodetesttask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import task.opencodetesttask.entities.FormPassage;
import task.opencodetesttask.repository.FormPassageRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/formPassages")
public class FormPassageController {

    private final FormPassageRepository repository;

    @Autowired
    public FormPassageController(FormPassageRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<FormPassage> getAll() {
        return repository.findAll();
    }

    @GetMapping(value = "/{id}")
    public FormPassage findById(@PathVariable("id") Long id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public long create(@RequestBody FormPassage resource) {
        Objects.requireNonNull(resource);
        return repository.save(resource).getId();
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id") long id, @RequestBody FormPassage resource) {
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
