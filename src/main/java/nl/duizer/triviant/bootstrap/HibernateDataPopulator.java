package nl.duizer.triviant.bootstrap;

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

    // SPORTS
    createQuestionCard("Welke wielrenner wordt ook wel de das genoemd?", "Bernard Hinault", Category.SPORTS);
    createQuestionCard("Hoeveel gouden medailles won Sven Kramer tijdens de Olympische winterspelen van 2010?", "",
        Category.SPORTS);
    createQuestionCard("Wie won er goud na de diskwalificatie van Sven Kwamer op de 10km schaatsen tijdens de " +
        "Olympische winterspelen van 2010?", "", Category.SPORTS);
    createQuestionCard("Van welke sport is Tjerk Kramer bekend?", "", Category.SPORTS);
    createQuestionCard("Van welke sport zijn de gebroeders Elmond bekend?", "", Category.SPORTS);
    createQuestionCard("Welke club werd Nederlands kampioen voetbal in 2006?", "", Category.SPORTS);
    createQuestionCard("Welke club werd Nederlands kampioen hockey bij de heren in 2012?", "", Category.SPORTS);
    createQuestionCard("Wat was de naam van de eerste atleet die 100m in minder dan tien seconden aflegde?", "",
        Category.SPORTS);

    // HISTORY
    createQuestionCard("Wat was het medicijn tegen de 19e eeuwse ‘ziekte’ Hysterie?", "", Category.HISTORY);
    createQuestionCard("Wat betekent de spreuk ‘Urbi et Orbi‘?", "", Category.HISTORY);
    createQuestionCard("Wat betekent de spreuk ‘Ora et Labora’?", "", Category.HISTORY);
    createQuestionCard("Wie was Otto von Bismarck ?", "", Category.HISTORY);
    createQuestionCard("Welke Franse verlichtingsfilosoof was de eerste die de bekende scheiding der machten(Trias " +
        "Politica) beschreef ?", "", Category.HISTORY);
    createQuestionCard("Welke Japanse steden weden in de tweede wereld oorlog gebombardeerd met een atoombom?", "",
        Category.HISTORY);

    // GEOGRAPHY
    createQuestionCard("Wat is hoofdstad van de deelstaat West - Falen ?", "", Category.GEOGRAPHY);
    createQuestionCard("Welke twee grote rivieren stromen door Irak?", "", Category.GEOGRAPHY);
    createQuestionCard("Wat is de hoogste berg ter wereld?", "", Category.GEOGRAPHY);
    createQuestionCard("Wat is de hoogste vulkaan ter wereld?", "", Category.GEOGRAPHY);
    createQuestionCard("In welk land staan de meeste vulkanen?", "", Category.GEOGRAPHY);
    createQuestionCard("Waar staat de afkorting U.S.S.R.voor?", "", Category.GEOGRAPHY);
    createQuestionCard("Wie wordt gezien als de grondlegger van het communisme?", "", Category.GEOGRAPHY);
    createQuestionCard("Wat was de naam van het land dat nu Myanmar heet?", "", Category.GEOGRAPHY);
    createQuestionCard("Welke stad stond vroeger bekend als Constantinopel?", "", Category.GEOGRAPHY);

    // SCIENCE
    createQuestionCard("Hoe heet de Nederlandse wetenschapper die in 2012 zijn baan als president van de KNAW " +
        "verruilde voor die", "", Category.SCIENCE);
    createQuestionCard("van directeur van het Institute for Advanced Study?", "", Category.SCIENCE);
    createQuestionCard("Waarvoor staat de afkorting KNAW?", "", Category.SCIENCE);
    createQuestionCard("Welke medische specialisatie richt zich onder meer op het onderzoek naar en de behandeling " +
        "van kanker?", "", Category.SCIENCE);
    createQuestionCard("Welke medische specialisatie houdt zich onder meer bezig met onderzoek naar en behandelingen " +
        "van de geslachtsorganen van de man.", "", Category.SCIENCE);
    createQuestionCard("Welke medische specialisatie houdt zich onder meer bezig met het onderzoek naar en " +
        "behandeling van de huid ?", "", Category.SCIENCE);
    createQuestionCard("Wie was de ontdekker van penicelline?", "", Category.SCIENCE);
    createQuestionCard("Wie was de uitvinder van de atoombom?", "", Category.SCIENCE);
    createQuestionCard("Wat is een cyclotron?", "", Category.SCIENCE);
    createQuestionCard("Wie was de uitvinder van het buskruit?", "", Category.SCIENCE);

    // ENTERTAINMENT
    createQuestionCard("Wat was het spel van het jaar 1999?", "", Category.ENTERTAINMENT);
    createQuestionCard("Welke film won een oscar voor beste animatiefilm in 2013?", "", Category.ENTERTAINMENT);
    createQuestionCard("Wat was de eerste Nederlandse film die een oscar won?", "", Category.ENTERTAINMENT);
    createQuestionCard("In welke serie is Carice van Houten te zien als … ?", "", Category.ENTERTAINMENT);
    createQuestionCard("Welke musical vertelt het verhaal voorafgaande aan The Wizard of Oz?", "",
        Category.ENTERTAINMENT);
    createQuestionCard("Welke acteur speelt dokter House in de gelijknamige televisieserie?", "",
        Category.ENTERTAINMENT);
    createQuestionCard("Wat was de naam het personage van Leonardo di Caprio in de film The Titanic?", "",
        Category.ENTERTAINMENT);
    createQuestionCard("Wat was de eerste nummer -1 hit van André Hazes?", "", Category.ENTERTAINMENT);
    createQuestionCard("Wat zijn de namen van de vier Beatles?", "", Category.ENTERTAINMENT);
    createQuestionCard("Welke mode -ontwerper ontwierp de bruidsjurk van Koningin Maxima?", "", Category.ENTERTAINMENT);

    log.info("Hibernate is done bootstrapping your data...");
  }

  private QuestionCard createQuestionCard(String question, String answer, Category category) {
    QuestionCard qCard = new QuestionCard();
    qCard.setQuestion(question);
    qCard.setAnswer(answer);
    qCard.setCategory(category);

    questionCardRepository.save(qCard);
    return qCard;
  }

}
