package org.nqh.asm2.service.impl;

import org.nqh.asm2.pojo.User;
import org.nqh.asm2.repository.UserRepository;
import org.nqh.asm2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Override
    public void save(User user) {
        user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
        if(user.getRoleByRoleId().getIdrole() == 2) {
            user.setStatus(0);
        } else {
            user.setStatus(1);
        }
        this.userRepository.save(user);
    }

    @Override
    public User getUserByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }

    @Override
    public User getUserById(int id) {
        User user = this.userRepository.findById(id).get();
        user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
        return user;
    }

    @Override
    public void update(User user) {
        User userUpdate = this.userRepository.findById(user.getIduser()).get();
        userUpdate.setFullName(user.getFullName());
        userUpdate.setAddress(user.getAddress());
        userUpdate.setPhoneNumber(user.getPhoneNumber());
        userUpdate.setEmail(user.getEmail());
        userUpdate.setDescription(user.getDescription());

        this.userRepository.save(userUpdate);
    }
}
