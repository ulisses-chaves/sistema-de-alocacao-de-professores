package com.Hirukar.Project.Models.Users_;

import com.Hirukar.Project.Connection.DAO.ProfessorDAO;
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
            Professor u = ProfessorDAO.getPeloNome(username);
            List<GrantedAuthority> grantedAuthority = AuthorityUtils.createAuthorityList(u.getCargo().toString());
            return new org.springframework.security.core.userdetails.User(u.getLogin(),u.getSenha(),grantedAuthority);
        }catch (Exception e){
            System.out.println("login falho");
            throw new UsernameNotFoundException(e.getMessage());
        }
    }
}
