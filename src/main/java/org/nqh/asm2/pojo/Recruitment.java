package org.nqh.asm2.pojo;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
public class Recruitment {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idrecruitment")
    private int idrecruitment;
    @Basic
    @Column(name = "address")
    private String address;
    @Basic
    @Column(name = "created_at")
    private String createdAt;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "experience")
    private String experience;
    @Basic
    @Column(name = "quantity")
    private Integer quantity;
    @Basic
    @Column(name = "\"rank\"")
    private String rank;
    @Basic
    @Column(name = "salary")
    private String salary;
    @Basic
    @Column(name = "status")
    private Integer status;
    @Basic
    @Column(name = "title")
    private String title;
    @Basic
    @Column(name = "type")
    private String type;
    @Basic
    @Column(name = "view")
    private String view;
    @Basic
    @Column(name = "deadline")
    private String deadline;
    @OneToMany(mappedBy = "recruitmentByRecruitmentId")
    private Collection<Applypost> applypostsByIdrecruitment;
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "idcategory")
    private Category categoryByCompanyId;
    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "idcompany")
    private Company companyByCompanyId;
    @OneToMany(mappedBy = "recruitmentByRecruitmentId")
    private Collection<SaveJob> saveJobsByIdrecruitment;

    public int getIdrecruitment() {
        return idrecruitment;
    }

    public void setIdrecruitment(int idrecruitment) {
        this.idrecruitment = idrecruitment;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public Collection<Applypost> getApplypostsByIdrecruitment() {
        return applypostsByIdrecruitment;
    }

    public void setApplypostsByIdrecruitment(Collection<Applypost> applypostsByIdrecruitment) {
        this.applypostsByIdrecruitment = applypostsByIdrecruitment;
    }

    public Category getCategoryByCompanyId() {
        return categoryByCompanyId;
    }

    public void setCategoryByCompanyId(Category categoryByCompanyId) {
        this.categoryByCompanyId = categoryByCompanyId;
    }

    public Company getCompanyByCompanyId() {
        return companyByCompanyId;
    }

    public void setCompanyByCompanyId(Company companyByCompanyId) {
        this.companyByCompanyId = companyByCompanyId;
    }

    public Collection<SaveJob> getSaveJobsByIdrecruitment() {
        return saveJobsByIdrecruitment;
    }

    public void setSaveJobsByIdrecruitment(Collection<SaveJob> saveJobsByIdrecruitment) {
        this.saveJobsByIdrecruitment = saveJobsByIdrecruitment;
    }
}
