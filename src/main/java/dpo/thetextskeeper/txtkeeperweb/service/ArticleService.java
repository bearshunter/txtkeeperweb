package dpo.thetextskeeper.txtkeeperweb.service;

import dpo.thetextskeeper.txtkeeperweb.entity.Article;
import dpo.thetextskeeper.txtkeeperweb.entity.Phrase;

import java.util.List;

public interface ArticleService  {


    Article createArticle(Article article);

    Phrase addPhrase(Phrase phrase);
}
