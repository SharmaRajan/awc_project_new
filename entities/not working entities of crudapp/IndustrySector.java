package com.dalmia.crudapp.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

//@Entity
//@Table(name = "industry_sector", uniqueConstraints = @UniqueConstraint(columnNames = { "industrySector" }))
public class IndustrySector {

        /*PHARMACEUTICALS,
        CHEMICAL,
        FMCG,
        AUTOMOBILE,
        PAINT,
        ULB_MUNICIPALITIES,
        PRO,
        OTHER*/

//        @Id
//        @EmbeddedId
        private long ind_id;

        private String ind_name;

        private String description;

        private String remarks;

//        @CreationTimestamp
//        @Column(name = "created_at", nullable = false, updatable = false)
//        @Temporal(TemporalType.TIMESTAMP)
        private Date createdAt;

//        @CreationTimestamp
//        @Column(name = "updated_at", nullable = false, updatable = true)
//        @Temporal(TemporalType.TIMESTAMP)
        private Date updatedAt;

        private Integer createdBy;

        private Integer updatedBy;


}
