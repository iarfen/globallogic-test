package com.globalLogicTest.model;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class User implements UserDetails {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Long id;
    
    @Column
    @NotNull
    public String name;

    @Column
    @NotNull
    @NotEmpty
    @Pattern(regexp="[A-Za-z0-9.-]+@[A-Za-z0-9]+\\.[A-Za-z0-9]+", message="Please provide a valid email address")
    public String email;

    @Column
    @NotNull
    @NotEmpty
    @Pattern(regexp="[A-Za-z0-9]+[0-9][0-9]", message="Please provide a valid password")
    @Size(min = 8, max = 12)
    public String password;

    @Column
    @OneToMany
    @NotNull
    public List<Phone> phones;

    @Column
    @NotNull
    @NotEmpty
    public Date createdAt;

    @Column
    @NotNull
    @NotEmpty
    public Date lastLogin;

    @Column
    @NotNull
    @NotEmpty
    public Boolean isActive;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getUsername() {
        return email;
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
        return isActive;
    }
}
