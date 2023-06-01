package com.dalmia.crudapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Calendar;

@Entity
@Table(name="role_access")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleAccess {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_access_id")
    private long roleAccessId;

    @Column(name = "approve")
    private int approvedRole;

    @Column(name = "create_role")
    private int createRole;

    @Column(name = "edit")
    private int editRole;

    @Column(name = "functionality")
    private String functionality;

    @Column(name = "view")
    private int view;

    @Column(name = "role")
    private int role;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_on")
    private Calendar createdOn;

    @Column(name = "modified_by")
    private String modifiedBy;

    @Column(name = "last_modified")
    private Calendar lastModified;

}
