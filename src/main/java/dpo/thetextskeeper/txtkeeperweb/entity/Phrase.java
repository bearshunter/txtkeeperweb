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
public class Phrase {

    public Phrase(long articleId, String enText, String deText) {
        this.articleId = articleId;
        this.enText = enText;
        this.deText = deText;
    }

    @Id
    @GeneratedValue
    private long id;
    private long articleId;
    private String enText;
    private String deText;
    private String ruText;
}
