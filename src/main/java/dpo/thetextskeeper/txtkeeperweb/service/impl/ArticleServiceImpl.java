package dpo.thetextskeeper.txtkeeperweb.service.impl;

import dpo.thetextskeeper.txtkeeperweb.entity.Article;
import dpo.thetextskeeper.txtkeeperweb.repository.ArticleRepository;
import dpo.thetextskeeper.txtkeeperweb.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;


    @Override
    public long create(Article article) {
        final Article savedArticle = articleRepository.save(article);
        log.info("article was saved with id:" + savedArticle.getId());
        return savedArticle.getId();

    }

    @Override
    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    @Override
    public Article findById(long id) {
        return articleRepository.findById(id).orElse(null);
    }
}
