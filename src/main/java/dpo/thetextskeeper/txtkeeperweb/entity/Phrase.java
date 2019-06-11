package dpo.thetextskeeper.txtkeeperweb.entity;

import javax.persistence.Entity;

@Entity
public class Phrase {

    private long id;
    private long pageId;
    private String enText;
    private String ruText;
    private String deText;
}
