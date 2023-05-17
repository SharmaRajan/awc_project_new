package com.dalmia.crudapp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "contact_person")
public class ContactPerson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cont_pers_id")
    private long contPersId;
    @NotBlank(message = "Name can not be empty !!")
    @Column(name = "cont_pers_name")
    private String contPersName;

    @Column(name = "cont_pers_number")
    private int contPersNumber;

    @Column(name = "cont_pers_designation")
    private String contPersDesign;

    @Email(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")
    @Column(name = "cont_pers_emailid")
    private String contPersEmailId;

    // A contact person has one facility
    @ManyToOne
    @JoinColumn(name = "fac_id")
    private Facility theFacility;

    public ContactPerson() {}

    public ContactPerson(String contPersName, int contPersNumber, String contPersDesign, String contPersEmailId, Facility facility) {
        this.contPersName = contPersName;
        this.contPersNumber = contPersNumber;
        this.contPersDesign = contPersDesign;
        this.contPersEmailId = contPersEmailId;
        this.theFacility = facility;
    }

    public ContactPerson(long contPersId, String contPersName, int contPersNumber, String contPersDesign, String contPersEmailId, Facility facility) {
        this.contPersId = contPersId;
        this.contPersName = contPersName;
        this.contPersNumber = contPersNumber;
        this.contPersDesign = contPersDesign;
        this.contPersEmailId = contPersEmailId;
        this.theFacility = facility;
    }


    public long getContPersId() {
        return contPersId;
    }

    public void setContPersId(long contPersId) {
        this.contPersId = contPersId;
    }

    public String getContPersName() {
        return contPersName;
    }

    public void setContPersName(String contPersName) {
        this.contPersName = contPersName;
    }

    public int getContPersNumber() {
        return contPersNumber;
    }

    public void setContPersNumber(int contPersNumber) {
        this.contPersNumber = contPersNumber;
    }

    public String getContPersDesign() {
        return contPersDesign;
    }

    public void setContPersDesign(String contPersDesign) {
        this.contPersDesign = contPersDesign;
    }

    public String getContPersEmailId() {
        return contPersEmailId;
    }

    public void setContPersEmailId(String contPersEmailId) {
        this.contPersEmailId = contPersEmailId;
    }

    public Facility getTheFacility() {
        return theFacility;
    }

    public void setTheFacility(Facility theFacility) {
        this.theFacility = theFacility;
    }
}
