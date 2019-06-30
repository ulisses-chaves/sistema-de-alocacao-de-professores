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
        Connection con = DatabaseConnection.getInstance().getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Professor prof = null;
        
        con = DatabaseConnection.getInstance().getConnection();
        stmt = con.prepareStatement(
                "SELECT * FROM professor " +
                "WHERE professor.Nome=?"
        );
        stmt.setString(1, nome);
        rs = stmt.executeQuery();
        if(rs.next())
            prof = new Professor(rs);
        
        DatabaseConnection.getInstance().close(con, rs, stmt);
        return prof;
    }
    
    public static ArrayList<Professor> listar() throws ClassNotFoundException, SQLException {
        Connection con = DatabaseConnection.getInstance().getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Professor> profesores = new ArrayList<>();
        
        con = DatabaseConnection.getInstance().getConnection();
        stmt = con.prepareStatement(
                "SELECT * FROM professor " +
                "WHERE 1"
        );
        while(rs.next())
            profesores.add(new Professor(rs));
        
        DatabaseConnection.getInstance().close(con, rs, stmt);
        return profesores;
    }
    
    public static void cadastrar(Professor professor) throws ClassNotFoundException, SQLException {
        Connection con = DatabaseConnection.getInstance().getConnection();
        PreparedStatement stmt = null;
        
        stmt = con.prepareStatement(
                "INSERT INTO professor " +
                "( Nome, CPF, FK_Disciplina_Preferencia_1,FK_Disciplina_Preferencia_2) " +
                "VALUES ( ?,?,?,?)"
        );
        stmt.setString(1, professor.getNome());
        stmt.setString(2, professor.getCPF());
        stmt.setInt(3, professor.getPreferencia1().getID());
        stmt.setInt(4, professor.getPreferencia2().getID());
        
        stmt.execute();
        
        DatabaseConnection.getInstance().close(con, stmt);
    }
    
    public static void atualiza(String login, Professor profNovo) throws ClassNotFoundException, SQLException {
        Connection con = DatabaseConnection.getInstance().getConnection();
        PreparedStatement stmt = null;
        
        con = DatabaseConnection.getInstance().getConnection();
        stmt = con.prepareStatement(
                "UPDATE professor" +
                "SET" +
                "	[Nome] = ?," +
                "	[CPF] = ?," +
                "	[Area] = ?," +
                "	[FK_Disciplina_Preferencia_1] = ?," +
                "	[FK_Disciplina_Preferencia_2] = ?," +
                "       [login] = ?"+
                "       [senha] = ?"+
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
        
        DatabaseConnection.getInstance().close(con, stmt);
    }
}
