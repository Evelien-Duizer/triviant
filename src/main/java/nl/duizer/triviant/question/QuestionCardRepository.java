package nl.duizer.triviant.question;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionCardRepository extends JpaRepository<QuestionCard, Long> {

  List<QuestionCard> findAllByCategory(Category category);

}
