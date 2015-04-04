package freeplace.lla.model.data.service.user;

import freeplace.lla.model.data.repositories.user.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import freeplace.lla.model.entities.user.Role;

@Service
public class RoleServiceImpl extends RoleService {
    
    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.jpaRepository = roleRepository;
    }
    
    @Override
    public Role findByName(String name) {
        return ((RoleRepository)jpaRepository).findByName(name);
    }

}