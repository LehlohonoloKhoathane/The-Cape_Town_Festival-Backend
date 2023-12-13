package za.ac.uct.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.uct.domain.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {
}
