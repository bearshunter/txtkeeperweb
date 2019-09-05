package dpo.thetextskeeper.txtkeeperweb.service.impl;

import dpo.thetextskeeper.txtkeeperweb.entity.Article;
import dpo.thetextskeeper.txtkeeperweb.entity.Phrase;
import dpo.thetextskeeper.txtkeeperweb.repository.ArticleRepository;
import dpo.thetextskeeper.txtkeeperweb.repository.PhraseRepository;
import dpo.thetextskeeper.txtkeeperweb.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private PhraseRepository phraseRepository;

    @Override
    public Article createArticle(Article article) {
        return articleRepository.save(article);
    }


    @Override
    public Phrase addPhrase(Phrase phrase) {
        return null;
    }
}
