package dpo.thetextskeeper.txtkeeperweb;

import dpo.thetextskeeper.txtkeeperweb.entity.Article;
import dpo.thetextskeeper.txtkeeperweb.entity.FileData;
import dpo.thetextskeeper.txtkeeperweb.entity.Phrase;
import dpo.thetextskeeper.txtkeeperweb.entity.User;
import dpo.thetextskeeper.txtkeeperweb.repository.ArticleRepository;
import dpo.thetextskeeper.txtkeeperweb.repository.FileDataRepository;
import dpo.thetextskeeper.txtkeeperweb.repository.UserRepository;
import dpo.thetextskeeper.txtkeeperweb.service.ArticleService;
import dpo.thetextskeeper.txtkeeperweb.service.PhraseService;
import dpo.thetextskeeper.txtkeeperweb.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class TxtkeeperWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(TxtkeeperWebApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(ArticleService articleService, PhraseService phraseService, UserService userService) {
        return (args) -> {

            final User savedUser = userService.save(new User("test", "test@mail.com"));
            for (int i = 1; i < 6; i++) {
                final Article article = new Article(savedUser.getId(), "Test article " + 1);
                article.setCreated(System.currentTimeMillis());
                final long articleId = articleService.create(article);
                phraseService.createPhrase(new Phrase(articleId,
                        "We wait for you.",
                        "Wir warten auf dich."));
                phraseService.createPhrase(new Phrase(articleId,
                        "Her family move in a new apartment tomorrow.",
                        "Ihre Familie ziehen morgen in eine neue Wohnung ein."));
                phraseService.createPhrase(new Phrase(articleId,
                        "She calls him every Sunday.",
                        "Sie ruft ihn jeden Sonntag an."));
                phraseService.createPhrase(new Phrase(articleId,
                        "I go through the park.",
                        "Ich gehe durch den Park."));
                phraseService.createPhrase(new Phrase(articleId,
                        "We work about an hour.",
                        "Wir arbeiten gegen eine Stunde."));
                phraseService.createPhrase(new Phrase(articleId,
                        "The children sit around the table.",
                        "Die Kinder sitzen um den Tisch herum."));
                phraseService.createPhrase(new Phrase(articleId,
                        "I am in a hurry.",
                        "Ich habe es eilig."));
                phraseService.createPhrase(new Phrase(articleId,
                        "My apartment consist of 3 rooms.",
                        "Meine Wohnung bestehet aus 3 Zimmern."));




            }
        };
    }

}
