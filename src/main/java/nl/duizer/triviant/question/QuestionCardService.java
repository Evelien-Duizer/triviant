package nl.duizer.triviant.question;

import lombok.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

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
    int idx = (int)(Math.random() * questionCards.size());
    return questionCards.get(idx);
  }
}
