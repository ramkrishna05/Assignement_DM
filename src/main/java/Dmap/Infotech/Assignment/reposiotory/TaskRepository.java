package Dmap.Infotech.Assignment.reposiotory;

// Repository
// TaskRepository.java



import Dmap.Infotech.Assignment.Model.Task;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface TaskRepository extends JpaRepository<Task, Long> {
}
