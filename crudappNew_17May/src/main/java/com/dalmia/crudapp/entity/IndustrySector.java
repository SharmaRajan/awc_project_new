package com.dalmia.crudapp.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "industry_sector")
public class IndustrySector {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ind_id")
    private long industryId;

    @Column(name = "ind_name")
    private String indName;

    @Column(name = "description")
    private String description;

    // an industry sector can have multiple companies
//    @JsonManagedReference
    @OneToMany(mappedBy = "industrySector")
    private Set<Company> companies;

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
