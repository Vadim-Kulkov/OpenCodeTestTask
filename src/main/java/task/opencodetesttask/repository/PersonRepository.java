package task.opencodetesttask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import task.opencodetesttask.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
