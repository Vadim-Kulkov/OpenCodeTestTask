package task.opencodetesttask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import task.opencodetesttask.entities.FormPassage;

@Repository
public interface FormPassageRepository extends JpaRepository<FormPassage, Long> {
}
