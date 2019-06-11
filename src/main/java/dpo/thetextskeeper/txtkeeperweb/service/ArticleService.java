package dpo.thetextskeeper.txtkeeperweb.service;

import dpo.thetextskeeper.txtkeeperweb.entity.Article;
import dpo.thetextskeeper.txtkeeperweb.entity.Phrase;

import java.util.List;

public interface ArticleService  {


    List<Article> findArticlesByOwner(long ownerId);


    Article createArticle(Article article);

    Phrase addPhraise(Phrase phrase);
}
