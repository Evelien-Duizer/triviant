package nl.duizer.triviant.question;

import java.util.List;
import lombok.NonNull;
import org.springframework.stereotype.Service;

@Service
public class QuestionCardService {

  QuestionCardRepository questionCardRepository;

  public QuestionCardService(QuestionCardRepository questionCardRepository) {
    this.questionCardRepository = questionCardRepository;
  }

  public QuestionCard getRandomQuestionCard(@NonNull String categoryName) {
    return getRandomQuestionCardFromList(questionCardRepository.findAllByCategory(Category.valueOf(categoryName)));
  }

  public QuestionCard getRandomQuestionCard() {
    List<QuestionCard> questionCards = questionCardRepository.findAll();
    return getRandomQuestionCardFromList(questionCards);
  }

  private QuestionCard getRandomQuestionCardFromList(List<QuestionCard> questionCards) {
    int idx = (int) (Math.random() * questionCards.size());
    return questionCards.get(idx);
  }
}
