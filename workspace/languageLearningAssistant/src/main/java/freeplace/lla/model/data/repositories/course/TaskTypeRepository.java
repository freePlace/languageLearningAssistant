package freeplace.lla.model.data.repositories.course;

import freeplace.lla.model.entities.course.TaskType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by klymenko.ruslan on 31.03.2015.
 */
@Repository
public interface TaskTypeRepository extends JpaRepository<TaskType, Long>{

    public static final String FIND_BY_NAME = "select tt from TaskType tt where name = :name";

    @Query(FIND_BY_NAME)
    public TaskType findByName(@Param("name") String name);
}
