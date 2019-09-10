package dpo.thetextskeeper.txtkeeperweb.repository;

import dpo.thetextskeeper.txtkeeperweb.entity.FileData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileDataRepository extends CrudRepository<FileData, Long> {

}
