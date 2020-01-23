package dpo.thetextskeeper.txtkeeperweb.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Lesson {


    @Id
    @GeneratedValue
    private long id;

    private long ownerId;

    private String headline;

    private long created;


    public Lesson(long ownerId, String headline) {
        this.ownerId = ownerId;
        this.headline = headline;
    }
}
