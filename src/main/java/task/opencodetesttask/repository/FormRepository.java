package task.opencodetesttask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import task.opencodetesttask.entities.Form;

@Repository
public interface FormRepository extends JpaRepository<Form, Long> {
}
