package dpo.thetextskeeper.txtkeeperweb.repository;

import dpo.thetextskeeper.txtkeeperweb.entity.PhraseCard;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhraseRepository extends CrudRepository<PhraseCard, Long> {

    @Query("select p from PhraseCard p where p.articleId = :articleId")
    List<PhraseCard> findByArticle(@Param("articleId") long articleId);

}
