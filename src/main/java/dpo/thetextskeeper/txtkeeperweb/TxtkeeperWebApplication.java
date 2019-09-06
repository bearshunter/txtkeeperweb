package dpo.thetextskeeper.txtkeeperweb;

import dpo.thetextskeeper.txtkeeperweb.entity.Article;
import dpo.thetextskeeper.txtkeeperweb.entity.User;
import dpo.thetextskeeper.txtkeeperweb.repository.ArticleRepository;
import dpo.thetextskeeper.txtkeeperweb.repository.UserRepository;
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
    public CommandLineRunner demo(ArticleRepository repository, UserRepository userRepository) {
        return (args) -> {
            final User savedUser = userRepository.save(new User("test", "test@mail.com"));
            for (int i = 1; i < 11; i++) {
                repository.save(new Article(savedUser.getId(), "Test article " + 1));
            }
        };
    }

}
