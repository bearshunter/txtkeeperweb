package dpo.thetextskeeper.txtkeeperweb.service;

import dpo.thetextskeeper.txtkeeperweb.entity.Lesson;

import java.util.List;

public interface ArticleService  {


    Lesson create(Lesson lesson);

    void update(Lesson lesson);


    List<Lesson> findAll();

    Lesson findById(long id);
}
