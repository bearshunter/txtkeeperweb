package dpo.thetextskeeper.txtkeeperweb.repository;

import dpo.thetextskeeper.txtkeeperweb.entity.Phrase;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhraseRepository extends CrudRepository<Phrase, Long> {

    @Query("select p from Phrase p where p.articleId = :articleId")
    List<Phrase> findByArticle(@Param("articleId") long articleId);

}
