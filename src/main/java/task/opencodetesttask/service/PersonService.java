package task.opencodetesttask.service;

import org.springframework.stereotype.Service;
import task.opencodetesttask.dto.UserWithRatingDto;
import task.opencodetesttask.dto.converter.UserWithRatingConverter;
import task.opencodetesttask.entities.Person;
import task.opencodetesttask.repository.PersonRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository repository;
    private final UserWithRatingConverter userWithRatingConverter;

    public PersonService(PersonRepository repository, UserWithRatingConverter userWithRatingConverter) {
        this.repository = repository;
        this.userWithRatingConverter = userWithRatingConverter;
    }

    public List<Person> findAll() {
        return repository.findAll();
    }

    public Person findById(long id) {
        Optional<Person> person = repository.findById(id);
        return person.orElse(null);
    }

    public long save(Person resource) {
        Objects.requireNonNull(resource);
        return repository.save(resource).getId();
    }

    public void deleteById(long id) {
        repository.deleteById(id);
    }

    public List<UserWithRatingDto> getRatings() {
        List<Person> persons = repository.findByOrderByPointsDesc();
        return userWithRatingConverter.convert(persons);
    }
}
