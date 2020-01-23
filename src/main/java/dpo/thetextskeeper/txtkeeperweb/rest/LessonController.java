package dpo.thetextskeeper.txtkeeperweb.rest;

import dpo.thetextskeeper.txtkeeperweb.entity.Lesson;
import dpo.thetextskeeper.txtkeeperweb.entity.PhraseCard;
import dpo.thetextskeeper.txtkeeperweb.rest.dto.LessonWithCardsDto;
import dpo.thetextskeeper.txtkeeperweb.service.ArticleService;
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
    private ArticleService articleService;

    @Autowired
    private PhraseService phraseService;

    @GetMapping("/")
    public List<Lesson> list() {
        return articleService.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<LessonWithCardsDto> getLessonWithCards(@PathVariable(name = "id") long id) {
        final Lesson lesson = articleService.findById(id);
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
        final Lesson createdLesson = articleService.create(newLesson);
        final List<PhraseCard> phraseCards = lessonWithCardsDto.getPhraseCards();
        phraseCards.forEach(phraseCard -> phraseCard.setLessonId(createdLesson.getId()));
        phraseService.createPhraseCards(phraseCards);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public Lesson updateAnArticle(@RequestBody Lesson lesson) {
        articleService.update(lesson);
        return articleService.findById(lesson.getId());
    }

}
