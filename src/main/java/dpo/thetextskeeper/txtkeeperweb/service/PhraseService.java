package dpo.thetextskeeper.txtkeeperweb.service;

import dpo.thetextskeeper.txtkeeperweb.entity.PhraseCard;

import java.util.List;

public interface PhraseService {

    void createPhrase(PhraseCard phrase);

    List<PhraseCard> findByArticle(long articleId);
}
