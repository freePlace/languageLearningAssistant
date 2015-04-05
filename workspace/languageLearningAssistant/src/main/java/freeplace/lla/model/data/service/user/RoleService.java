package freeplace.lla.model.data.service.user;

import freeplace.lla.model.data.repositories.user.RoleRepository;
import freeplace.lla.model.data.service.BasicService;
import freeplace.lla.model.entities.user.Role;

public abstract class RoleService
        extends BasicService<RoleRepository, Role> {
    abstract Role findByName(String name);
}

