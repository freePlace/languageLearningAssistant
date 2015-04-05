package freeplace.lla.model.data.service.global;

import freeplace.lla.model.data.repositories.global.MetadataRepository;
import freeplace.lla.model.data.service.BasicService;
import freeplace.lla.model.entities.global.Metadata;

public abstract class MetadataService
        extends BasicService<MetadataRepository, Metadata> {
    abstract Metadata get();
}
