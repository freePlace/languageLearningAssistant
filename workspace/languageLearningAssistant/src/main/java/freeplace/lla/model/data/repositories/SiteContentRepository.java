package freeplace.lla.model.data.repositories;

import freeplace.lla.model.entities.SiteContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by klymenko.ruslan on 28.03.2015.
 */
@Repository
public interface SiteContentRepository extends JpaRepository<SiteContent, Long>{
}
