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
    createQuestionCard("Van welke sport is Tjerk Kramer bekend?", "Waterpolo", Category.SPORTS);
    createQuestionCard("Van welke sport zijn de gebroeders Elmond bekend?", "Judo", Category.SPORTS);
    createQuestionCard("Welke club werd Nederlands kampioen voetbal in het seizoen 2006/2007?", "PSV", Category.SPORTS);
    createQuestionCard("Welke club werd Nederlands kampioen hockey bij de heren in het seizoen 2012/2013?", "Oranje Zwart", Category.SPORTS);
    createQuestionCard("Wat was de naam van de eerste atleet die 100m in minder dan tien seconden aflegde?", "Jim Hines",
        Category.SPORTS);

    // HISTORY
    createQuestionCard("Wat was het medicijn tegen de 19e eeuwse ‘ziekte’ Hysterie?", "Vibrator", Category.HISTORY);
    createQuestionCard("Wat betekent de spreuk ‘Urbi et Orbi‘?", "De stad (Rome) en de wereld", Category.HISTORY);
    createQuestionCard("Wat betekent de spreuk ‘Ora et Labora’?", "Bid en werk", Category.HISTORY);
    createQuestionCard("Welke Franse verlichtingsfilosoof was de eerste die de bekende scheiding der machten(Trias " +
        "Politica) beschreef?", "Charles Montesquieu", Category.HISTORY);
    createQuestionCard("Welke Japanse steden weden in de tweede wereld oorlog gebombardeerd met een atoombom?", "Nagasaki en Hiroshima",
        Category.HISTORY);

    // GEOGRAPHY
    createQuestionCard("Wat is hoofdstad van de deelstaat West-Falen?", "Düsseldorf", Category.GEOGRAPHY);
    createQuestionCard("Welke twee grote rivieren stromen door Irak?", "Eufraat en Tigris", Category.GEOGRAPHY);
    createQuestionCard("Wat is de hoogste berg ter wereld?", "Mount Everest", Category.GEOGRAPHY);
    createQuestionCard("Wat is de hoogste vulkaan ter wereld?", "Ojos del Salado", Category.GEOGRAPHY);
    createQuestionCard("Waar staat de afkorting U.S.S.R.voor?", "Unie van Socialistische SovjetRepublieken", Category.GEOGRAPHY);
    createQuestionCard("Wie wordt gezien als de grondlegger van het communisme?", "Karl Marckx", Category.GEOGRAPHY);
    createQuestionCard("Wat was de naam van het land dat nu Myanmar heet?", "Birma", Category.GEOGRAPHY);
    createQuestionCard("Welke stad stond vroeger bekend als Constantinopel?", "Istanbul", Category.GEOGRAPHY);

    // SCIENCE
    createQuestionCard("Hoe heet de Nederlandse wetenschapper die in 2012 zijn baan als president van de KNAW" +
        "verruilde voor die van directeur van het Institute for Advanced Study?", "Robert Dijkgraag", Category.SCIENCE);
    createQuestionCard("Waarvoor staat de afkorting KNAW?", "Koninklijk Nederlandse Academie voor Wetenschap", Category.SCIENCE);
    createQuestionCard("Welke medische specialisatie richt zich onder meer op het onderzoek naar en de behandeling " +
        "van kanker?", "Onologie", Category.SCIENCE);
    createQuestionCard("Welke medische specialisatie houdt zich onder meer bezig met onderzoek naar en behandelingen " +
        "van de geslachtsorganen van de man.", "Urologie", Category.SCIENCE);
    createQuestionCard("Welke medische specialisatie houdt zich onder meer bezig met het onderzoek naar en " +
        "behandeling van de huid ?", "Dermatologie", Category.SCIENCE);
    createQuestionCard("Wie was de ontdekker van penicelline?", "Alexander Fleming", Category.SCIENCE);
    createQuestionCard("Wie wordt ook wel de vader van de atoombom genoemd?", "Robert Oppenheimer", Category.SCIENCE);
    createQuestionCard("Wat is een cyclotron?", "Een circulaire deeltjesversneller", Category.SCIENCE);
    createQuestionCard("Wie was de uitvinder van het dynamiet?", "Afred Nobel", Category.SCIENCE);

    // ENTERTAINMENT
    createQuestionCard("Wat was het spel van het jaar 1999?", "Kolonisten van Catan", Category.ENTERTAINMENT);
    createQuestionCard("Welke film won een oscar voor beste animatiefilm in 2013?", "Frozen", Category.ENTERTAINMENT);
    createQuestionCard("Wat was de eerste Nederlandse film die een oscar won?", "De Aanslag", Category.ENTERTAINMENT);
    createQuestionCard("In welke serie is Carice van Houten te zien als 'Melisandre'?", "Game of Thrones", Category.ENTERTAINMENT);
    createQuestionCard("Welke musical vertelt het verhaal voorafgaande aan The Wizard of Oz?", "Wicked",
        Category.ENTERTAINMENT);
    createQuestionCard("Welke acteur speelt dokter House in de gelijknamige televisieserie?", "Greg ",
        Category.ENTERTAINMENT);
    createQuestionCard("Wat was de naam het personage van Leonardo di Caprio in de film The Titanic?", "Jack Dawson",
        Category.ENTERTAINMENT);
    createQuestionCard("Wat was de eerste nummer-1 hit van André Hazes?", "Eenzame Kerst", Category.ENTERTAINMENT);
    createQuestionCard("Wat zijn de namen van de vier Beatles?", "John Lennon, Paul McCartney, George Harrison, Ringo Starr", Category.ENTERTAINMENT);
    createQuestionCard("Welke mode-ontwerper ontwierp de bruidsjurk van Koningin Maxima?", "Valentino", Category.ENTERTAINMENT);

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
