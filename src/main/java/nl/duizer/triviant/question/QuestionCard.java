package nl.duizer.triviant.question;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class QuestionCard {

  @JsonIgnore
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(updatable = false, nullable = false)
  private String uuid = UUID.randomUUID().toString();

  @NotNull
  private String question;

  @NotNull
  private String answer;

  @NotNull
  @Enumerated(EnumType.STRING)
  private Category category;

  public QuestionCard() {}
}
