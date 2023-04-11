package task.opencodetesttask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import task.opencodetesttask.entities.Person;
import task.opencodetesttask.repository.PersonRepository;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonRepository repository;

    @Autowired
    public PersonController(PersonRepository personRepository) {
        this.repository = personRepository;
    }

    @GetMapping
    public List<Person> getAll() {
        return repository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Person findById(@PathVariable("id") Long id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public long create(@RequestBody Person resource) {
        Objects.requireNonNull(resource);
        return repository.save(resource).getId();
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id") long id, @RequestBody Person resource) {
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
