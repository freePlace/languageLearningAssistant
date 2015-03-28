package freeplace.lla.model.data.repositories;

import freeplace.lla.model.entities.SiteContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by klymenko.ruslan on 28.03.2015.
 */
@Repository
public interface SiteContentRepository extends JpaRepository<SiteContent, Long>{

    public static final String FIND_ENGLISH_SITE_CONTENT = "select english from site_content";
    public static final String FIND_FRENCH_SITE_CONTENT = "select french from site_content";
    public static final String FIND_RUSSIAN_SITE_CONTENT = "select russian from site_content";

    @Query(value = FIND_ENGLISH_SITE_CONTENT, nativeQuery = true)
    List<String> findEnglish();

    @Query(value = FIND_FRENCH_SITE_CONTENT, nativeQuery = true)
    List<String> findFrench();

    @Query(value = FIND_RUSSIAN_SITE_CONTENT, nativeQuery = true)
    List<String> findRussian();
}
