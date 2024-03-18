package org.nqh.asm2.pojo;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "save_job", schema = "asm2", catalog = "")
public class SaveJob {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idsave_job")
    private int idsaveJob;
    @ManyToOne
    @JoinColumn(name = "recruitment_id", referencedColumnName = "idrecruitment")
    private Recruitment recruitmentByRecruitmentId;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "iduser")
    private User userByUserId;

    public int getIdsaveJob() {
        return idsaveJob;
    }

    public void setIdsaveJob(int idsaveJob) {
        this.idsaveJob = idsaveJob;
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
