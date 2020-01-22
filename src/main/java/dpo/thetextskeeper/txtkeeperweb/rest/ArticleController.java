package dpo.thetextskeeper.txtkeeperweb.rest;

import dpo.thetextskeeper.txtkeeperweb.entity.Article;
import dpo.thetextskeeper.txtkeeperweb.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/")
    public List<Article> list() {
        return articleService.findAll();
    }


    @GetMapping("/{id}")
    public Article list(@PathVariable(name = "id") long id) {
        return articleService.findById(id);
    }


    @PostMapping
    public Article createAnArticle(@RequestBody Article article) {
        long articleId = articleService.create(article);
        return articleService.findById(articleId);
    }

    @PutMapping("/{id}")
    public Article updateAnArticle(@RequestBody Article article) {
        articleService.update(article);
        return articleService.findById(article.getId());
    }

}
