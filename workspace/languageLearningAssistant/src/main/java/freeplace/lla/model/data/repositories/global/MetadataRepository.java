package freeplace.lla.model.data.repositories.global;

import org.springframework.data.jpa.repository.JpaRepository;
import freeplace.lla.model.entities.global.Metadata;
import org.springframework.stereotype.Repository;

@Repository
public interface MetadataRepository extends JpaRepository<Metadata, Long>{
}
