package dpo.thetextskeeper.txtkeeperweb.service;

import dpo.thetextskeeper.txtkeeperweb.entity.Lesson;
import dpo.thetextskeeper.txtkeeperweb.rest.dto.LessonWithCardsDto;

import java.util.List;

public interface LessonService {


    Lesson create(Lesson lesson);

    void update(Lesson lesson);

    List<Lesson> findAll();

    Lesson findById(long id);

    void delete(long id);

}
