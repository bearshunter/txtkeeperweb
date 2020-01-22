package dpo.thetextskeeper.txtkeeperweb.service;

import dpo.thetextskeeper.txtkeeperweb.entity.Article;

import java.util.List;

public interface ArticleService  {


    long create(Article article);

    void update(Article article);


    List<Article> findAll();

    Article findById(long id);
}
