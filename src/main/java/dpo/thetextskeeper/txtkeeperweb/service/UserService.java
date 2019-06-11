package dpo.thetextskeeper.txtkeeperweb.service;


import dpo.thetextskeeper.txtkeeperweb.entity.User;

public interface UserService {
    User findById(long id);

    User save(User newUser);
}
