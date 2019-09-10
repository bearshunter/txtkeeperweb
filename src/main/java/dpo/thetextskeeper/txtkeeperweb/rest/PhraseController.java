package dpo.thetextskeeper.txtkeeperweb.rest;

import dpo.thetextskeeper.txtkeeperweb.entity.Phrase;
import dpo.thetextskeeper.txtkeeperweb.service.PhraseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PhraseController {

    @Autowired
    private PhraseService phraseService;

    @GetMapping("/article/{articleId}/phrase/")
    public List<Phrase> list( @PathVariable("articleId") long articleId) {
        return phraseService.findByArticle(articleId);
    }

}
