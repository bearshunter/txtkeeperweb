package dpo.thetextskeeper.txtkeeperweb.demo;

import dpo.thetextskeeper.txtkeeperweb.entity.User;
import dpo.thetextskeeper.txtkeeperweb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class DatabaseLoader implements CommandLineRunner {

    @Autowired
    private UserRepository repository;


    @Override
    public void run(String... strings) throws Exception {
        this.repository.save(new User("Frodo", "Baggins", "ring bearer"));
    }
}