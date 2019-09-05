package dpo.thetextskeeper.txtkeeperweb.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Article {


    @Id
    private long id;

    private long ownerId;


    private String headline;


}
