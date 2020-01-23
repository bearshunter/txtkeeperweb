package dpo.thetextskeeper.txtkeeperweb.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class PhraseCard implements Serializable {


    public PhraseCard(long lessonId, String phrase, String translation) {
        this.lessonId = lessonId;
        this.phrase = phrase;
        this.translation = translation;
    }


    @Id
    @GeneratedValue
    private long id;
    private long lessonId;
    @NotBlank(message = "phrase is mandatory")
    private String phrase;
    @NotBlank(message = "translation is mandatory")
    private String translation;
}
