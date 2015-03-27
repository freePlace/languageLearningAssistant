package freeplace.lla.model.data.service;

import freeplace.lla.model.data.repositories.MetadataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import freeplace.lla.model.entities.Metadata;

import java.util.List;

@Service
public class MetadataServiceImpl implements MetadataService<Metadata>{
    
    private final MetadataRepository metadataRepository;
    
    @Autowired
    public MetadataServiceImpl(MetadataRepository metadataRepository) {
        this.metadataRepository = metadataRepository;
    }
    @Override
    public Metadata get() {
        return metadataRepository.findOne((long) 1);
    }

    @Override
    public Metadata add(Metadata object) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Metadata update(Metadata object) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(Metadata object) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Metadata> findAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Metadata findById(Long id) {
        throw new UnsupportedOperationException();
    }
}
