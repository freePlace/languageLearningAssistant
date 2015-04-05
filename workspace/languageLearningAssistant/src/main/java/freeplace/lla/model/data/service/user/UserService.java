package freeplace.lla.model.data.service.user;

import freeplace.lla.model.data.repositories.user.UserRepository;
import freeplace.lla.model.data.service.BasicService;
import freeplace.lla.model.entities.user.User;

import java.util.List;

public abstract class UserService
        extends BasicService<UserRepository, User> {
    abstract List<User> findByName(String name);
    abstract List<User> findByLastName(String lastName);
    abstract User findByEmail(String email);
    abstract User findByLogin(String login);
}
