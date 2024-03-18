package org.nqh.asm2.service.impl;

import org.nqh.asm2.pojo.Role;
import org.nqh.asm2.repository.RoleRepository;
import org.nqh.asm2.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> getAllRole() {
        return this.roleRepository.findAll();
    }

    @Override
    public Role getRoleById(int id) {
        return this.roleRepository.findById(id).get();
    }
}
