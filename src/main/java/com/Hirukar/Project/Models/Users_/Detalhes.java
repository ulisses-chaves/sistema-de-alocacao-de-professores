package com.Hirukar.Project.Models.Users_;

import com.Hirukar.Project.Connection.DAO.ProfessorDAO;
import java.sql.SQLException;
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
            System.out.println("carregando");
            ProfessorDAO.listar().forEach((t) -> {
                System.out.println("tem esse prof:"+t.getNome());
            });
            System.out.println();
            
            
            Professor u = ProfessorDAO.getPeloNome(username);
            System.out.println("e....");
            List<GrantedAuthority> grantedAuthority = AuthorityUtils.createAuthorityList(u.getCargo().toString());
            return new org.springframework.security.core.userdetails.User(u.getLogin(),u.getSenha(),grantedAuthority);
        }catch (ClassNotFoundException | SQLException e){
            System.out.println("login falho; erro :"+e.getMessage());
            throw new UsernameNotFoundException(e.getMessage());
        }
    }
}
