package dpo.thetextskeeper.txtkeeperweb.repository;

import dpo.thetextskeeper.txtkeeperweb.entity.Article;

import java.util.List;

public interface ArticleRepository   {
    List<Article> findByOwnerId(long ownerId);
}
