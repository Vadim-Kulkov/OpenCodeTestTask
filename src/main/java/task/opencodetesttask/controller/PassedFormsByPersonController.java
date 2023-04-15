package task.opencodetesttask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import task.opencodetesttask.entities.FormPassage;
import task.opencodetesttask.entities.Person;
import task.opencodetesttask.repository.FormPassageRepository;
import task.opencodetesttask.repository.PersonRepository;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("persons/{personId}/passedForms")
public class PassedFormsByPersonController {

    private final PersonRepository personRepository;
    private final FormPassageRepository formPassageRepository;

    @Autowired
    public PassedFormsByPersonController(PersonRepository personRepository, FormPassageRepository formPassageRepository) {
        this.personRepository = personRepository;
        this.formPassageRepository = formPassageRepository;
    }

    @GetMapping
    public Set<FormPassage> getAllPassedFormsByPersonId(@PathVariable("personId") long id) throws ClassNotFoundException {
        Optional<Person> requiredPerson = personRepository.findById(id);
        if (requiredPerson.isPresent()) {
            return requiredPerson.get().getPassedForms();
        } else {
            throw new ClassNotFoundException();
        }
    }

    @PutMapping("/{formId}")
    public void setRepeatablePassedFormForPerson(@PathVariable("formId") long formId,
                                                 @RequestParam boolean value) throws ClassNotFoundException {
        Optional<FormPassage> requiredFormPassage = formPassageRepository.findById(formId);
        if (requiredFormPassage.isPresent()) {
            requiredFormPassage.get().setRepeatable(value);
        } else {
            throw new ClassNotFoundException();
        }
    }
}
