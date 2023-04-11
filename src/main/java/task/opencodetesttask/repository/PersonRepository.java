package task.opencodetesttask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import task.opencodetesttask.entities.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
