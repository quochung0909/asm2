package org.nqh.asm2.config;

import java.util.Collection;
import java.util.UUID;

import org.nqh.asm2.pojo.Role;
import org.nqh.asm2.pojo.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails {

    private User user; // Your custom User class

    public CustomUserDetails(User user) {
        this.user = user;
    }

    public CustomUserDetails(User user, Collection<? extends GrantedAuthority> authorities) {
        this.user = user;
    }

    // Implement UserDetails methods by delegating to the User object
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail(); 
    }

    // Additional methods to expose custom information
    public String getFullName() {
        return user.getFullName();
    }

    public int getUserId() {
        return user.getIduser();
    }

    public Role getRole() {
        return user.getRoleByRoleId();
    }

    public UUID getUuid() {
        return this.user.getUuid();
    }



    // Other getters for additional information

    // Implement other UserDetails methods as needed

    @Override
    public boolean isAccountNonExpired() {
        return true; // Add your logic here
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Add your logic here
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Add your logic here
    }

    @Override
    public boolean isEnabled() {
        return true; // Add your logic here
    }

}
