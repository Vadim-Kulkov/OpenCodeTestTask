package task.opencodetesttask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import task.opencodetesttask.dto.UserWithRatingDto;
import task.opencodetesttask.entities.Person;
import task.opencodetesttask.service.PersonService;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<Person> getAll() {
        return personService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Person findById(@PathVariable("id") long id) {
        return personService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public long create(@RequestBody Person resource) {
        return personService.save(resource);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id") long id, @RequestBody Person resource) {
        resource.setId(id);
        personService.save(resource);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") long id) {
        personService.deleteById(id);
    }

    @GetMapping(value = "/getRatings")
    public List<UserWithRatingDto> getRatings() {
        return personService.getRatings();
    }
}
