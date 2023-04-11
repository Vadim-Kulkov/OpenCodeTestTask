package task.opencodetesttask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import task.opencodetesttask.entities.Form;

public interface FormRepository extends JpaRepository<Form, Long> {
}
