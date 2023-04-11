package task.opencodetesttask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import task.opencodetesttask.entities.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
