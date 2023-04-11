package task.opencodetesttask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import task.opencodetesttask.entities.Answer;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
