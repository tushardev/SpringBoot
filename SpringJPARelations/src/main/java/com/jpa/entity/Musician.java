package com.jpa.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "musician")
public class Musician {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "musician_id")
    private Long musicianId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "date_of_birth")
    private LocalDateTime dateOfBirth;

    @Column(name = "primary_instrument")
    private String primaryInstrument;

    /*** Here the join column value is Musician table column. ***/
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "institute_id")
    private MusicInstitute musicInstitute;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "musician_cds",
                joinColumns = @JoinColumn(name = "musician_id"),
                inverseJoinColumns = @JoinColumn(name = "cd_id"))
    List<CD> cds;


    public Long getMusicianId() {
        return musicianId;
    }

    public void setMusicianId(Long musicianId) {
        this.musicianId = musicianId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPrimaryInstrument() {
        return primaryInstrument;
    }

    public void setPrimaryInstrument(String primaryInstrument) {
        this.primaryInstrument = primaryInstrument;
    }

    public MusicInstitute getMusicInstitute() {
        return musicInstitute;
    }

    public void setMusicInstitute(MusicInstitute musicInstitute) {
        this.musicInstitute = musicInstitute;
    }

    public List<CD> getCds() {
        return cds;
    }

    public void setCds(List<CD> cds) {
        this.cds = cds;
    }
}

/*****
 * Join column denotes that this entity owns the relation
 */
