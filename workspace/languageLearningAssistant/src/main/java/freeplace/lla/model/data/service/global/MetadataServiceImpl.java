package freeplace.lla.model.data.service.global;

import freeplace.lla.model.data.repositories.global.MetadataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import freeplace.lla.model.entities.global.Metadata;

@Service
public class MetadataServiceImpl extends MetadataService {
    
    @Autowired
    public MetadataServiceImpl(MetadataRepository metadataRepository) {
        this.jpaRepository = metadataRepository;
    }

    @Override
    public Metadata get() {
        return super.findAll().get(0);
    }
}
