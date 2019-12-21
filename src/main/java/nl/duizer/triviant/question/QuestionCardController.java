package nl.duizer.triviant.question;

import java.util.Objects;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionCardController {

  private QuestionCardService questionCardService;

  public QuestionCardController(QuestionCardService questionCardService) {
    this.questionCardService = questionCardService;
  }

  @GetMapping(value = "/")
  public ResponseEntity<QuestionCard> getQuestionCard(@RequestParam(required = false) String category) {
    QuestionCard questionCard = null;
    if (Objects.nonNull(category)) {
      questionCard = questionCardService.getRandomQuestionCard(category);
    } else {
      questionCard = questionCardService.getRandomQuestionCard();
    }
    return ResponseEntity.ok(questionCard);
  }

}
