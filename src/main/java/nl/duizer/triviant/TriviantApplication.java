package nl.duizer.triviant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication(scanBasePackages = {"nl.duizer.triviant"})
public class TriviantApplication {
  public static void main(String[] args) {
    SpringApplication.run(TriviantApplication.class, args);
  }
}
