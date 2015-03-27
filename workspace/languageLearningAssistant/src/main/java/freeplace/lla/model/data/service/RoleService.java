package freeplace.lla.model.data.service;

public interface RoleService<Role> extends BasicService<Role> {
    Role findByName(String name);
}

