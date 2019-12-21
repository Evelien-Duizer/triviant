package nl.duizer.triviant.bootstrap;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
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
  public void afterPropertiesSet() throws URISyntaxException {
    log.info("Hibernate is bootstrapping your data...");

    log.info("Creating Question Cards!");

    URI uri = ClassLoader.getSystemResource("").toURI();
    String mainPath = Paths.get(uri).toString();

    try (Stream<String> stream = Files.lines(Paths.get(mainPath,"/questions.csv"))) {
      stream.forEach(line -> {
        String[] questionArray = line.split(";");
        createQuestionCard(questionArray[0], questionArray[1], questionArray[2], questionArray[3]);
      });
    } catch (IOException e) {
      e.printStackTrace();
    }


    log.info("Hibernate is done bootstrapping your data...");
  }

  private QuestionCard createQuestionCard(String question, String answer, String category, String uuid) {
    QuestionCard questionCard = new QuestionCard();
    questionCard.setQuestion(question);
    questionCard.setAnswer(answer);
    questionCard.setCategory(Category.valueOf(category));
    questionCard.setUuid(uuid);

    questionCardRepository.save(questionCard);
    return questionCard;
  }

}
