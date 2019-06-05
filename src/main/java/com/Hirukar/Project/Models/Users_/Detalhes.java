package com.Hirukar.Project.Models.Users_;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Detalhes implements UserDetailsService{
    @Override
    public UserDetails loadUserByUsername(String username){
        try{
            User_ u = new User_(username);
            List<GrantedAuthority> grantedAuthority = AuthorityUtils.createAuthorityList(u.getROLES());
            return new org.springframework.security.core.userdetails.User(u.getLogin(),u.getPassword(),grantedAuthority);
        }catch (Exception e){
            System.out.println("login falho");
            throw new UsernameNotFoundException(e.getMessage());
        }
    }
}
