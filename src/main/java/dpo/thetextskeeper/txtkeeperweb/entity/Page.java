package dpo.thetextskeeper.txtkeeperweb.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
public class Page implements Serializable {

    @Id
    private long id;

    private String name;

}
