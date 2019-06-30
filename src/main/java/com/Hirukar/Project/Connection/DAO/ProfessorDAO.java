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
        
        DatabaseConnection.getInstance().close(con, rs, stmt);
        return prof;
    }
    
    public static ArrayList<Professor> listar() throws ClassNotFoundException, SQLException {
        Connection con = DatabaseConnection.getInstance().getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Professor> profesores = new ArrayList<>();

        DatabaseConnection.getInstance().close(con, rs, stmt);
        return profesores;
    }
    
    public static void cadastrar(Professor professor) throws ClassNotFoundException, SQLException {
        Connection con = DatabaseConnection.getInstance().getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        DatabaseConnection.getInstance().close(con, rs, stmt);
    }
}
