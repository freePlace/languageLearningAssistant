package freeplace.lla.model.data.repositories.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import freeplace.lla.model.entities.user.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

    public static final String FIND_ROLE_BY_NAME = "select r from Role r where r.name = :name";

    @Query(FIND_ROLE_BY_NAME)
    Role findByName(@Param("name") String name);
}

