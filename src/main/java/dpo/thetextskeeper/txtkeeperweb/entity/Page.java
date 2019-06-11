package dpo.thetextskeeper.txtkeeperweb.entity;

import lombok.Data;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
public class Page implements Serializable {

    private long id;

    private String name;

    private List<Phrase> phrases;
}
