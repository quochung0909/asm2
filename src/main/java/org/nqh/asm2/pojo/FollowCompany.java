package org.nqh.asm2.pojo;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "follow_company", schema = "asm2", catalog = "")
public class FollowCompany {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idfollow_company")
    private int idfollowCompany;
    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "idcompany")
    private Company companyByCompanyId;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "iduser")
    private User userByUserId;

    public int getIdfollowCompany() {
        return idfollowCompany;
    }

    public void setIdfollowCompany(int idfollowCompany) {
        this.idfollowCompany = idfollowCompany;
    }

    public Company getCompanyByCompanyId() {
        return companyByCompanyId;
    }

    public void setCompanyByCompanyId(Company companyByCompanyId) {
        this.companyByCompanyId = companyByCompanyId;
    }

    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }
}
