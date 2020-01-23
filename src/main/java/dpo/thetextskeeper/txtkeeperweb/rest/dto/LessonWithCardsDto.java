package dpo.thetextskeeper.txtkeeperweb.rest.dto;

import dpo.thetextskeeper.txtkeeperweb.entity.PhraseCard;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class LessonWithCardsDto implements Serializable {

    private long lessonId;

    private String headline;

    private List<PhraseCard> phraseCards;
}
