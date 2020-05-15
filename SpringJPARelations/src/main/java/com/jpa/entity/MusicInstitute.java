package com.jpa.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "music_institute")
public class MusicInstitute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "institute_id")
    private Long instituteId;

    @Column(name = "institute_name")
    private String instituteName;

    @Column(name = "institute_address")
    private String instituteAdd;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "musicInstitute", fetch = FetchType.LAZY)
    List<Musician> musicians;


    public Long getInstituteId() {
        return instituteId;
    }

    public void setInstituteId(Long instituteId) {
        this.instituteId = instituteId;
    }

    public String getInstituteName() {
        return instituteName;
    }

    public void setInstituteName(String instituteName) {
        this.instituteName = instituteName;
    }

    public String getInstituteAdd() {
        return instituteAdd;
    }

    public void setInstituteAdd(String instituteAdd) {
        this.instituteAdd = instituteAdd;
    }

    public List<Musician> getMusicians() {
        return musicians;
    }

    public void setMusicians(List<Musician> musicians) {
        this.musicians = musicians;
    }
}

/**** mapped by denotes this is other side of relationship which doesn't own the relationship **/