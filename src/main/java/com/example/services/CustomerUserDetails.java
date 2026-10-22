package com.example.services;

import com.example.models.UserInfo;
import com.example.models.UserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomerUserDetails extends UserInfo implements UserDetails
{

    private String username;

    private String password;

    Collection<? extends GrantedAuthority> grantedAuthorities;

    public CustomerUserDetails(UserInfo userInfo)
    {
        this.username = userInfo.getUsername();
        this.password = userInfo.getPassword();
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        for ( UserRole role :  userInfo.getRoles())
        {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }


    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        return grantedAuthorities;
    }

    @Override
    public boolean isAccountNonExpired()
    {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked()
    {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired()
    {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled()
    {
        return UserDetails.super.isEnabled();
    }
}
