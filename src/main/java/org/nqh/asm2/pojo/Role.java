package org.nqh.asm2.pojo;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
public class Role {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idrole")
    private int idrole;
    @Basic
    @Column(name = "role_name")
    private String roleName;
    @OneToMany(mappedBy = "roleByRoleId")
    private Collection<User> usersByIdrole;

    public int getIdrole() {
        return idrole;
    }

    public void setIdrole(int idrole) {
        this.idrole = idrole;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return idrole == role.idrole && Objects.equals(roleName, role.roleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idrole, roleName);
    }

    public Collection<User> getUsersByIdrole() {
        return usersByIdrole;
    }

    public void setUsersByIdrole(Collection<User> usersByIdrole) {
        this.usersByIdrole = usersByIdrole;
    }
}
