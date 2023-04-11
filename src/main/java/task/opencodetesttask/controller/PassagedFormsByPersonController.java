package task.opencodetesttask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import task.opencodetesttask.entities.FormPassage;
import task.opencodetesttask.entities.Person;
import task.opencodetesttask.repository.PersonRepository;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("persons/{personId}/passagedForms")
public class PassagedFormsByPersonController {

    private final PersonRepository personRepository;

    @Autowired
    public PassagedFormsByPersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping
    public Set<FormPassage> getAllByPerson(@PathVariable("personId") long id) throws ClassNotFoundException {
        Optional<Person> requiredPerson = personRepository.findById(id);
        if (requiredPerson.isPresent()) {
            return requiredPerson.get().getPassagedForms();
        } else {
            throw new ClassNotFoundException();
        }
    }
}
