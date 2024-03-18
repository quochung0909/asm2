package org.nqh.asm2.service;

import org.nqh.asm2.pojo.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAllRole();
    Role getRoleById(int id);
}
