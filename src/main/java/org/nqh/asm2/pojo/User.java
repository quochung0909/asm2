package org.nqh.asm2.pojo;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.UUID;
import java.io.Serializable;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class User implements Serializable{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "iduser")
    private int iduser;
    @Basic
    @Column(name = "address")
    private String address;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "full_name")
    private String fullName;
    @Basic
    @Column(name = "image")
    private String image;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "phone_number")
    private String phoneNumber;
    @Basic
    @Column(name = "status")
    private Integer status;
    @OneToMany(mappedBy = "userByUserId")
    private Collection<Applypost> applypostsByIduser;
    @OneToOne(mappedBy = "userByUserId")
    private Company companiesByIduser;
    @OneToMany(mappedBy = "userByUserId")
    private Collection<Cv> cvsByIduser;
    @OneToMany(mappedBy = "userByUserId")
    private Collection<FollowCompany> followCompaniesByIduser;
    @OneToMany(mappedBy = "userByUserId")
    private Collection<SaveJob> saveJobsByIduser;

  

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "idrole")
    private Role roleByRoleId;
    @ManyToOne
    @JoinColumn(name = "cv_id", referencedColumnName = "idcv")
    private Cv cvByCvId;

    @Transient
    private UUID uuid;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Collection<Applypost> getApplypostsByIduser() {
        return applypostsByIduser;
    }

    public void setApplypostsByIduser(Collection<Applypost> applypostsByIduser) {
        this.applypostsByIduser = applypostsByIduser;
    }

    public Company getCompaniesByIduser() {
        return companiesByIduser;
    }

    public void setCompaniesByIduser(Company cpn) {
        this.companiesByIduser = cpn;
    }

    public Collection<Cv> getCvsByIduser() {
        return cvsByIduser;
    }

    public void setCvsByIduser(Collection<Cv> cvsByIduser) {
        this.cvsByIduser = cvsByIduser;
    }

    public Collection<FollowCompany> getFollowCompaniesByIduser() {
        return followCompaniesByIduser;
    }

    public void setFollowCompaniesByIduser(Collection<FollowCompany> followCompaniesByIduser) {
        this.followCompaniesByIduser = followCompaniesByIduser;
    }

    public Collection<SaveJob> getSaveJobsByIduser() {
        return saveJobsByIduser;
    }

    public void setSaveJobsByIduser(Collection<SaveJob> saveJobsByIduser) {
        this.saveJobsByIduser = saveJobsByIduser;
    }

    public Role getRoleByRoleId() {
        return roleByRoleId;
    }

    public void setRoleByRoleId(Role roleByRoleId) {
        this.roleByRoleId = roleByRoleId;
    }

    public Cv getCvByCvId() {
        return cvByCvId;
    }

    public void setCvByCvId(Cv cvByCvId) {
        this.cvByCvId = cvByCvId;
    }
}
