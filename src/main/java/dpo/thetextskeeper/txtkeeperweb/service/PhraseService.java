package dpo.thetextskeeper.txtkeeperweb.service;

import dpo.thetextskeeper.txtkeeperweb.entity.Phrase;

import java.util.List;

public interface PhraseService {

    void createPhrase(Phrase phrase);

    List<Phrase> findByArticle(long articleId);
}
