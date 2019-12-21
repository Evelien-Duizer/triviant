package nl.duizer.triviant.question;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionCardRepository extends JpaRepository<QuestionCard, Long> {

  List<QuestionCard> findAllByCategory(Category category);

}
