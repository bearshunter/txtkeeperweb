package dpo.thetextskeeper.txtkeeperweb.repository;

import dpo.thetextskeeper.txtkeeperweb.entity.Article;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ArticleRepository extends CrudRepository<Article, Long> {

    @Query("select a from Article a")
    List<Article> findAll();


}
