package dpo.thetextskeeper.txtkeeperweb;

import dpo.thetextskeeper.txtkeeperweb.entity.Article;
import dpo.thetextskeeper.txtkeeperweb.entity.PhraseCard;
import dpo.thetextskeeper.txtkeeperweb.entity.User;
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
                final Article article = new Article(savedUser.getId(), "Test article " + i);
                article.setCreated(System.currentTimeMillis());
                final long articleId = articleService.create(article);
                phraseService.createPhrase(new PhraseCard(articleId,
                        "We wait for you.",
                        "Wir warten auf dich."));
                phraseService.createPhrase(new PhraseCard(articleId,
                        "Her family move in a new apartment tomorrow.",
                        "Ihre Familie ziehen morgen in eine neue Wohnung ein."));
                phraseService.createPhrase(new PhraseCard(articleId,
                        "She calls him every Sunday.",
                        "Sie ruft ihn jeden Sonntag an."));
                phraseService.createPhrase(new PhraseCard(articleId,
                        "I go through the park.",
                        "Ich gehe durch den Park."));
                phraseService.createPhrase(new PhraseCard(articleId,
                        "We work about an hour.",
                        "Wir arbeiten gegen eine Stunde."));
                phraseService.createPhrase(new PhraseCard(articleId,
                        "The children sit around the table.",
                        "Die Kinder sitzen um den Tisch herum."));
                phraseService.createPhrase(new PhraseCard(articleId,
                        "I am in a hurry.",
                        "Ich habe es eilig."));
                phraseService.createPhrase(new PhraseCard(articleId,
                        "My apartment consist of 3 rooms.",
                        "Meine Wohnung bestehet aus 3 Zimmern."));
            }
        };
    }

}
