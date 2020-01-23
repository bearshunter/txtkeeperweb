package dpo.thetextskeeper.txtkeeperweb.service.impl;

import dpo.thetextskeeper.txtkeeperweb.entity.PhraseCard;
import dpo.thetextskeeper.txtkeeperweb.repository.PhraseCardRepository;
import dpo.thetextskeeper.txtkeeperweb.service.PhraseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PhraseServiceImpl implements PhraseService {

    @Autowired
    private PhraseCardRepository phraseCardRepository;


    public void createPhrase(PhraseCard phrase) {
        phraseCardRepository.save(phrase);
    }

    public void createPhraseCards(List<PhraseCard> phrase) {
        phraseCardRepository.saveAll(phrase);
    }


    @Override
    public List<PhraseCard> findByLesson(long lessonId) {
        return phraseCardRepository.findByLesson(lessonId);
    }


}
