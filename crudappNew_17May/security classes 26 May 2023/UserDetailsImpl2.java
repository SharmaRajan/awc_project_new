package com.dalmia.crudapp.serviceImpl;


import com.dalmia.crudapp.entity.UserNotWorking;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Objects;


public class UserDetailsImpl implements UserDetails {
    private static final long serialVersionUID = 1L;

    private Long userId;

    private String username;

    private String email;

    @JsonIgnore
    private String password;

    private UserNotWorking theUserNotWorking;

    private Collection<? extends GrantedAuthority> authorities;

    public UserDetailsImpl(Long id, String username, String email, String password) {
        this.userId = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public UserDetailsImpl(Long id, String username, String email, String password,
                           Collection<? extends GrantedAuthority> authorities) {
        this.userId = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

    public UserDetailsImpl(UserNotWorking userNotWorking){
        this.theUserNotWorking = userNotWorking;
    }

    public static UserDetailsImpl build(UserNotWorking userNotWorking) {
//        List<GrantedAuthority> authorities = user.getRoles().stream()
//                .map(role -> new SimpleGrantedAuthority(role.getRoleCode()))
//                .collect(Collectors.toList());

        return new UserDetailsImpl(
                userNotWorking.getUserId(),
                userNotWorking.getUsername(),
                userNotWorking.getEmail(),
                userNotWorking.getPassword());
//               , authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public Long getId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserDetailsImpl user = (UserDetailsImpl) o;
        return Objects.equals(userId, user.userId);
    }
}
