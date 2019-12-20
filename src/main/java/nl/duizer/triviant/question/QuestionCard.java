package nl.duizer.triviant.question;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class QuestionCard {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  private String question;

  @NotNull
  private String answer;

  @NotNull
  @Enumerated(EnumType.STRING)
  private Category category;

  public QuestionCard() {}
}
