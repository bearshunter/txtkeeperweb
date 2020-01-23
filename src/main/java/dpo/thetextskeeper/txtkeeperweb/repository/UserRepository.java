package dpo.thetextskeeper.txtkeeperweb.repository;

import dpo.thetextskeeper.txtkeeperweb.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends CrudRepository<User, Long> {


}
