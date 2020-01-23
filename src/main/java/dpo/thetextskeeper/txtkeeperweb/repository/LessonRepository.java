package dpo.thetextskeeper.txtkeeperweb.repository;

import dpo.thetextskeeper.txtkeeperweb.entity.Lesson;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface LessonRepository extends CrudRepository<Lesson, Long> {

    @Query("select a from Lesson a")
    List<Lesson> findAll();


}
