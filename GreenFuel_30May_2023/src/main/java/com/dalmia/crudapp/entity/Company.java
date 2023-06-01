package com.dalmia.crudapp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.*;

@Entity
@Table(name = "company")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="comp_id")
    private long compId;

    @Column(name="company_name")
    private String companyName;


    @Column(name="presence")
    private String presence;

    @Column(name="total_no_of_facility")
    private long totalNoOfFacility;

    // A company has many facilities
//    @JsonBackReference
    @OneToMany(mappedBy = "theCompany"
            ,cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    private Set<Facility> facilities = new HashSet<>();

    // a company originate from single industry sector
//    @JsonBackReference
//    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL, targetEntity = IndustrySector.class)
//    @JoinColumn(name = "industry_id",referencedColumnName = "ind_id") // referencedColumnName = add primary key of industry sector to map it here

    @ManyToOne
    @JoinColumn(name = "ind_sector_id", referencedColumnName = "ind_id")
//    @Column(name = "industry_sector")
    private IndustrySector industrySector;

    @Column(name = "industry_sector_id")
    private long theIndustrySector;

    @Column(name = "APPROVED_BY")
    private String approvedBy;


    @Column(name = "STATUS")
    private String status;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATED_ON")
    private Calendar createdOn;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LAST_MODIFIED")
    private Calendar lastModified;

    @Column(name = "CREATED_BY")
    private String createdBy;

    @Column(name = "MODIFIED_BY")
    private String modifiedBy;
}
