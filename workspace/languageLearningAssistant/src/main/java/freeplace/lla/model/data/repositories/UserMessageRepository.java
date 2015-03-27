package freeplace.lla.model.data.repositories;

import freeplace.lla.model.entities.UserMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by klymenko.ruslan on 27.03.2015.
 */
@Repository
public interface UserMessageRepository extends JpaRepository<UserMessage, Long> {

    public static final String FIND_NEW_USER_MESSAGES = "select um from UserMessage um where um.isNew = :isNew";
    public static final String FIND_CRITICAL_USER_MESSAGES = "select um from UserMessage um where um.isCritical = :isCritical";
    public static final String FIND_ALL_ORDER_BY_DATE_ASC = "select um from UserMessage um order by date asc";
    public static final String FIND_ALL_ORDER_BY_DATE_DESC = "select um from UserMessage um order by date desc";

    @Query(FIND_NEW_USER_MESSAGES)
    List<UserMessage> findByIsNew(@Param("isNew") Boolean isNew);

    @Query(FIND_CRITICAL_USER_MESSAGES)
    List<UserMessage> findByIsCritical(@Param("isCritical") Boolean isCritical);

    @Query(FIND_ALL_ORDER_BY_DATE_ASC)
    List<UserMessage> findAllOrderByDateAsc();

    @Query(FIND_ALL_ORDER_BY_DATE_DESC)
    List<UserMessage> findAllOrderByDateDesc();
}
