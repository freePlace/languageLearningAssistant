package freeplace.lla.model.data.repositories;

import freeplace.lla.model.entities.MainMenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by klymenko.ruslan on 28.03.2015.
 */
@Repository
public interface MainMenuItemRepository extends JpaRepository<MainMenuItem, Long>{
}
