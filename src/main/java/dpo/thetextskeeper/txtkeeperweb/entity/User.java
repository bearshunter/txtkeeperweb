package dpo.thetextskeeper.txtkeeperweb.entity;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "keeper_user")
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;


    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
}

