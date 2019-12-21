package nl.duizer.triviant.bootstrap;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;
import nl.duizer.triviant.question.Category;
import nl.duizer.triviant.question.QuestionCard;
import nl.duizer.triviant.question.QuestionCardRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class HibernateDataPopulator implements InitializingBean {

  QuestionCardRepository questionCardRepository;

  HibernateDataPopulator(QuestionCardRepository questionCardRepository) {
    this.questionCardRepository = questionCardRepository;
  }

  @Override
  public void afterPropertiesSet() {
    log.info("Hibernate is bootstrapping your data...");

    log.info("Creating Question Cards!");

    try (Stream<String> stream = Files.lines(Paths.get(this.getClass()
        .getResource("/questions.csv")
        .getFile()))) {
      stream.forEach(line -> {
        String[] questionArray = line.split(";");
        createQuestionCard(questionArray[0], questionArray[1], Category.valueOf(questionArray[2]));
      });
    } catch (IOException e) {
      e.printStackTrace();
    }


    log.info("Hibernate is done bootstrapping your data...");
  }

  private QuestionCard createQuestionCard(String question, String answer, Category category) {
    QuestionCard questionCard = new QuestionCard();
    questionCard.setQuestion(question);
    questionCard.setAnswer(answer);
    questionCard.setCategory(category);

    questionCardRepository.save(questionCard);
    return questionCard;
  }

}
