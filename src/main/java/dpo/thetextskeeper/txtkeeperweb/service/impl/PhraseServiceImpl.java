package dpo.thetextskeeper.txtkeeperweb.service.impl;

import dpo.thetextskeeper.txtkeeperweb.entity.PhraseCard;
import dpo.thetextskeeper.txtkeeperweb.repository.PhraseRepository;
import dpo.thetextskeeper.txtkeeperweb.service.PhraseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PhraseServiceImpl implements PhraseService {

    @Autowired
    private PhraseRepository phraseRepository;


    public void createPhrase(PhraseCard phrase){
        phraseRepository.save(phrase);
    }

    @Override
    public List<PhraseCard> findByArticle(long articleId) {
        return phraseRepository.findByArticle(articleId);
    }
}
