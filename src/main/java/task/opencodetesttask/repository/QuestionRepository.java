package task.opencodetesttask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import task.opencodetesttask.entities.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
}
