package freeplace.lla.model.data.repositories;

import freeplace.lla.model.entities.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by klymenko.ruslan on 22.03.2015.
 */
@Repository
public interface LanguageRepository extends JpaRepository<Language, Long> {

    public static final String FIND_LANGUAGE_BY_NAME = "select l from Language l where l.name = :name";

    @Query(FIND_LANGUAGE_BY_NAME)
    Language findByName(@Param("name") String name);
}
