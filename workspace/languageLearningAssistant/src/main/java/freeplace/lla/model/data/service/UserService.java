package freeplace.lla.model.data.service;

import java.util.List;

public interface UserService<User> extends BasicService<User> {
    List<User> findByName(String name);
    List<User> findByLastName(String lastName);
    User findByEmail(String email);
    User findByLogin(String login);
}
