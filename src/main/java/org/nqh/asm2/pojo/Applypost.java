package org.nqh.asm2.pojo;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Applypost {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idapplypost")
    private int idapplypost;
    @Basic
    @Column(name = "created_at")
    private String createdAt;
    @Basic
    @Column(name = "name_cv")
    private String nameCv;
    @Basic
    @Column(name = "status")
    private Integer status;
    @Basic
    @Column(name = "text")
    private String text;
    @ManyToOne
    @JoinColumn(name = "recruitment_id", referencedColumnName = "idrecruitment")
    private Recruitment recruitmentByRecruitmentId;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "iduser")
    private User userByUserId;

    public int getIdapplypost() {
        return idapplypost;
    }

    public void setIdapplypost(int idapplypost) {
        this.idapplypost = idapplypost;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getNameCv() {
        return nameCv;
    }

    public void setNameCv(String nameCv) {
        this.nameCv = nameCv;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Recruitment getRecruitmentByRecruitmentId() {
        return recruitmentByRecruitmentId;
    }

    public void setRecruitmentByRecruitmentId(Recruitment recruitmentByRecruitmentId) {
        this.recruitmentByRecruitmentId = recruitmentByRecruitmentId;
    }

    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }
}
