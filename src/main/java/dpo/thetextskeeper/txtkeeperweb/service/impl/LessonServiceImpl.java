package dpo.thetextskeeper.txtkeeperweb.service.impl;

import dpo.thetextskeeper.txtkeeperweb.entity.Lesson;
import dpo.thetextskeeper.txtkeeperweb.entity.PhraseCard;
import dpo.thetextskeeper.txtkeeperweb.repository.LessonRepository;
import dpo.thetextskeeper.txtkeeperweb.repository.PhraseCardRepository;
import dpo.thetextskeeper.txtkeeperweb.service.LessonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class LessonServiceImpl implements LessonService {

    @Autowired
    private LessonRepository lessonRepository;

    @Autowired
    private PhraseCardRepository phraseCardRepository;


    @Override
    public Lesson create(Lesson lesson) {
        final Lesson savedLesson = lessonRepository.save(lesson);
        log.info("article was saved with id:" + savedLesson.getId());
        return savedLesson;
    }


    @Override
    public void update(Lesson lesson) {
        lessonRepository.save(lesson);
    }

    @Override
    public List<Lesson> findAll() {
        return lessonRepository.findAll();
    }

    @Override
    public Lesson findById(long id) {
        return lessonRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(long id) {
       lessonRepository.deleteById(id);
    }
}
