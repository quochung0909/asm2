package org.nqh.asm2.service;

import org.nqh.asm2.pojo.User;

/*
    * @project asm2
    * @Author nqh
    * @create 29-12-2023
    *
    * Các chức năng liên quan đến user
 */
public interface UserService {
    void save(User user);

    User getUserByEmail(String email);

    User getUserById(int id);

    void update(User user);
}
