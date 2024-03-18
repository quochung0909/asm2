package org.nqh.asm2.pojo;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
public class Category {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idcategory")
    private int idcategory;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "number_choose")
    private Integer numberChoose;
    @OneToMany(mappedBy = "categoryByCompanyId")
    private Collection<Recruitment> recruitmentsByIdcategory;

    public int getIdcategory() {
        return idcategory;
    }

    public void setIdcategory(int idcategory) {
        this.idcategory = idcategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumberChoose() {
        return numberChoose;
    }

    public void setNumberChoose(Integer numberChoose) {
        this.numberChoose = numberChoose;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return idcategory == category.idcategory && Objects.equals(name, category.name) && Objects.equals(numberChoose, category.numberChoose);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idcategory, name, numberChoose);
    }

    public Collection<Recruitment> getRecruitmentsByIdcategory() {
        return recruitmentsByIdcategory;
    }

    public void setRecruitmentsByIdcategory(Collection<Recruitment> recruitmentsByIdcategory) {
        this.recruitmentsByIdcategory = recruitmentsByIdcategory;
    }
}
