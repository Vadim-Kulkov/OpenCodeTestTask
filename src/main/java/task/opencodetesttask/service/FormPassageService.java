package task.opencodetesttask.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task.opencodetesttask.entities.Answer;
import task.opencodetesttask.entities.FormPassage;
import task.opencodetesttask.entities.Person;
import task.opencodetesttask.repository.FormPassageRepository;
import task.opencodetesttask.repository.PersonRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

@Service
public class FormPassageService {

    private final FormPassageRepository formPassageRepository;
    private final PersonRepository personRepository;

    @Autowired
    public FormPassageService(FormPassageRepository formPassageRepository, PersonRepository personRepository) {
        this.formPassageRepository = formPassageRepository;
        this.personRepository = personRepository;
    }

    public List<FormPassage> findAll() {
        return formPassageRepository.findAll();
    }

    public FormPassage findById(long id) {
        Optional<FormPassage> formPassage = formPassageRepository.findById(id);
        return formPassage.orElse(null);
    }

    public long save(FormPassage resource) {
        Objects.requireNonNull(resource);
        calculatePoints(resource);
        return formPassageRepository.save(resource).getId();
    }

    public void deleteById(long id) {
        formPassageRepository.deleteById(id);
    }

    private void calculatePoints(FormPassage formPassage)  {
        Person person = formPassage.getPerson();
        Set<Answer> userAnswers = formPassage.getAnswers();
        for (Answer answer : userAnswers) {
            if (answer.isCorrect()) {
                person.setPoints(person.getPoints() + 1);
            }
        }
        personRepository.save(person);
    }
}
