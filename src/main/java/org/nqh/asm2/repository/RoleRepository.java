package org.nqh.asm2.repository;

import org.nqh.asm2.pojo.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/*
    * @project asm2
    * @Author nqh
    * @create 29-12-2023
    *
    * Các chức năng liên quan đến role  (vai trò)
 */
public interface RoleRepository extends JpaRepository<Role, Integer> {
}
