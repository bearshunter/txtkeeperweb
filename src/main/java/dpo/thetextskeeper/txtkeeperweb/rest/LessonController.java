package dpo.thetextskeeper.txtkeeperweb.rest;

import dpo.thetextskeeper.txtkeeperweb.entity.Lesson;
import dpo.thetextskeeper.txtkeeperweb.entity.PhraseCard;
import dpo.thetextskeeper.txtkeeperweb.repository.PhraseCardRepository;
import dpo.thetextskeeper.txtkeeperweb.rest.dto.LessonWithCardsDto;
import dpo.thetextskeeper.txtkeeperweb.service.LessonService;
import dpo.thetextskeeper.txtkeeperweb.service.PhraseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/lesson")
public class LessonController {

    @Autowired
    private LessonService lessonService;

    @Autowired
    private PhraseService phraseService;

    @GetMapping("/")
    public List<Lesson> list() {
        return lessonService.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<LessonWithCardsDto> getLessonWithCards(@PathVariable(name = "id") long id) {
        final Lesson lesson = lessonService.findById(id);
        LessonWithCardsDto lessonWithCardsDto = new LessonWithCardsDto();
        lessonWithCardsDto.setLessonId(id);
        List<PhraseCard> cards = phraseService.findByLesson(lesson.getId());
        lessonWithCardsDto.setPhraseCards(cards);
        lessonWithCardsDto.setHeadline(lesson.getHeadline());
        return new ResponseEntity<>(lessonWithCardsDto, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Void> createLesson(@RequestBody LessonWithCardsDto lessonWithCardsDto) {
        final Lesson newLesson = new Lesson();
        newLesson.setHeadline(lessonWithCardsDto.getHeadline());
        newLesson.setCreated(System.currentTimeMillis());
        newLesson.setOwnerId(42L);
        final Lesson createdLesson = lessonService.create(newLesson);
        final List<PhraseCard> phraseCards = lessonWithCardsDto.getPhraseCards();
        phraseCards.forEach(phraseCard -> phraseCard.setLessonId(createdLesson.getId()));
        phraseService.createPhraseCards(phraseCards);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateALesson(@RequestBody LessonWithCardsDto lesson) {
        final Lesson updatedLesson = lessonService.findById(lesson.getLessonId());
        updatedLesson.setHeadline(lesson.getHeadline());
        lessonService.update(updatedLesson);

        phraseService.deleteByLessonId(lesson.getLessonId());
        final List<PhraseCard> phraseCards = lesson.getPhraseCards();
        phraseCards.forEach(phraseCard -> phraseCard.setLessonId(lesson.getLessonId()));
        phraseService.createPhraseCards(phraseCards);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable(name = "id") long id) {
        lessonService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
