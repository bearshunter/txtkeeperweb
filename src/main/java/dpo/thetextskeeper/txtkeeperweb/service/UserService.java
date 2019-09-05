package dpo.thetextskeeper.txtkeeperweb.service;


import dpo.thetextskeeper.txtkeeperweb.entity.User;

import java.util.List;

public interface UserService {
    User findById(long id);

    User save(User newUser);

    List<User> findAll();
}
