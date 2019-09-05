package dpo.thetextskeeper.txtkeeperweb.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Phrase {

    @Id
    private long id;
    private long pageId;
    private String enText;
    private String ruText;
    private String deText;
}
