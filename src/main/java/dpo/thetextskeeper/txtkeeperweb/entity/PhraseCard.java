package dpo.thetextskeeper.txtkeeperweb.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class PhraseCard {

    @Id
    @GeneratedValue
    private long id;
    private long articleId;
    @NotBlank(message = "phrase is mandatory")
    private String phrase;
    @NotBlank(message = "translation is mandatory")
    private String translation;
}
