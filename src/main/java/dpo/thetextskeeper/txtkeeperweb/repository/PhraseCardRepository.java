package dpo.thetextskeeper.txtkeeperweb.repository;

import dpo.thetextskeeper.txtkeeperweb.entity.PhraseCard;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PhraseCardRepository extends CrudRepository<PhraseCard, Long> {

    @Query("select p from PhraseCard p where p.lessonId = :lessonId")
    List<PhraseCard> findByLesson(@Param("lessonId") long lessonId);


    @Transactional
    void  deleteAllByLessonId( long lessonId);

}
