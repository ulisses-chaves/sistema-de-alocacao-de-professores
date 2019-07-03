package com.Hirukar.Project.Connection.DAO;

import com.Hirukar.Project.Connection.ConnectionFactory.DatabaseConnection;
import com.Hirukar.Project.Models.Users_.Professor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class ProfessorDAO {
    
    public static Professor getPeloNome(String nome) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Professor prof = null;
        try{
            con = DatabaseConnection.getInstance().getConnection();
            stmt = con.prepareStatement(
                    "SELECT * FROM professor " +
                    "WHERE professor.login=?"
            );
            stmt.setString(1, nome);
            rs = stmt.executeQuery();
            if(rs.next())
                prof = new Professor(rs);
            else
                prof = new Professor();
        }catch(ClassNotFoundException | SQLException e){
            throw e;
        }finally{
            DatabaseConnection.getInstance().close(con, rs, stmt);
        }
        return prof;
    }
    
    public static ArrayList<Professor> listar() throws ClassNotFoundException, SQLException {
        Connection con = DatabaseConnection.getInstance().getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Professor> profesores = new ArrayList<>();
        
        con = DatabaseConnection.getInstance().getConnection();
        stmt = con.prepareStatement(
                "SELECT * FROM professor WHERE 1"
        );
        rs = stmt.executeQuery();
        while(rs.next()){
            profesores.add(new Professor(rs));
        }
        
        DatabaseConnection.getInstance().close(con, rs, stmt);
        return profesores;
    }
    
    public static void cadastrar(Professor professor) throws ClassNotFoundException, SQLException {
        Connection con  = null;
        PreparedStatement stmt = null;
        
        try{
            con = DatabaseConnection.getInstance().getConnection();
            stmt = con.prepareStatement(
                    "INSERT INTO professor\n" +
                    "( \n" +
                    " 	CPF, Nome, Area,login,senha,cargo\n" +
                    ")\n" +
                    "VALUES\n" +
                    "(\n" +
                    "	?,?,?,?,?,?\n" +
                    ")"
            );
            stmt.setString(1, professor.getCPF());
            stmt.setString(2, professor.getNome());
            stmt.setString(3, professor.getArea().name());
            stmt.setString(4, professor.getLogin());
            stmt.setString(5, professor.getSenha());
            stmt.setString(6, professor.getCargo().name());

            stmt.execute();
        }catch(ClassNotFoundException | SQLException e){
            throw e;
        }finally{
            DatabaseConnection.getInstance().close(con, stmt);
        }   
    }
    
    public static void atualiza(String login, Professor profNovo) throws ClassNotFoundException, SQLException {
        PreparedStatement stmt = null;
        Connection con  = null;
        
        try{
        con = DatabaseConnection.getInstance().getConnection();
        stmt = con.prepareStatement(
                "UPDATE professor" +
                "SET" +
                "	Nome = ?," +
                "	CPF = ?," +
                "	Area = ?," +
                "	FK_Disciplina_Preferencia_1 = ?," +
                "	FK_Disciplina_Preferencia_2 = ?," +
                "       login = ?"+
                "       senha = ?"+
                "WHERE 	professor.nome=?"
        );
        stmt.setString(1, profNovo.getNome());
        stmt.setString(2, profNovo.getCPF());
        stmt.setString(3, profNovo.getArea().name());
        stmt.setInt(4, profNovo.getPreferencia1().getID());
        stmt.setInt(5, profNovo.getPreferencia2().getID());
        stmt.setString(6, login);
        stmt.setString(7, profNovo.getSenha());
        stmt.execute();
        }catch(ClassNotFoundException | SQLException e){
            throw e;
        }finally{
            DatabaseConnection.getInstance().close(con, stmt);
        }
        
    }
}
