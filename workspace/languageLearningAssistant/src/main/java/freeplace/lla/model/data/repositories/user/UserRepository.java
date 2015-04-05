package freeplace.lla.model.data.repositories.user;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import freeplace.lla.model.entities.user.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public static final String FIND_USER_BY_NAME = "select u from User u where u.name = :name";
    public static final String FIND_USER_BY_LAST_NAME = "select u from User u where u.lastName = :lastName";
    public static final String FIND_USER_BY_EMAIL = "select u from User u where u.email = :email";
    public static final String FIND_USER_BY_LOGIN = "select u from User u where u.login = :login";

    @Query(FIND_USER_BY_NAME)
    List<User> findByName(@Param("name") String name);
    
    @Query(FIND_USER_BY_LAST_NAME)
    List<User> findByLastName(@Param("lastName") String lastName);
    
    @Query(FIND_USER_BY_EMAIL)
    User findByEmail(@Param("email") String email);
    
    @Query(FIND_USER_BY_LOGIN)
    User findByLogin(@Param("login") String login);
}
