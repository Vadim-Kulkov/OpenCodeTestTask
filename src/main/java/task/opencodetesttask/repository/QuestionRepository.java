package task.opencodetesttask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import task.opencodetesttask.entities.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
