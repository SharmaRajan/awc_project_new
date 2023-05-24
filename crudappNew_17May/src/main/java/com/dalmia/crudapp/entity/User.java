package com.dalmia.crudapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Calendar;

@Entity
@Table(name="user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long userId;

    @Column(name = "email_id")
    private String emailId;

    @Column(name = "password")
    private String password;

//    @Column(name = "no_of_attempts")
//    private int noOfAttempts;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_on")
    private Calendar createdOn;

    @Column(name = "modified_by")
    private String modifiedBy;

    @Column(name = "last_modified")
    private Calendar lastModified;

    @Column(name = "approved_by")
    private String approvedBy;

    @Column(name = "is_logged_in")
    private boolean isLoggedIn;

    @Column(name = "last_login_time")
    private Calendar lastLoginTime;

    @Column(name = "last_login_attempt_time")
    private Calendar lastLoginAttemptTime;

    @Column(name = "last_logout_time")
    private Calendar lastLogoutTime;

    @Column(name = "login_count")
    private int loginCount;

    @Column(name = "manager_email")
    private String managerEmail;

    @Column(name = "manager_id")
    private long managerId;

    @Column(name = "manager_name")
    private String managerName;

}
