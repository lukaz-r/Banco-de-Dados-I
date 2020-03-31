package model.dao;

import java.sql.Connection;
import model.database.DatabasePostgreSQL;
import model.domain.Aluno;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;



public class AlunoDAO {
    private Connection con;
    
    
    public AlunoDAO(){
        this.con = new DatabasePostgreSQL().conectar();
    }
    
    public boolean add(Aluno a){
        String sql = "INSERT INTO Aluno (pnome, unome, telefone, matricula) VALUES(?,?,?,?)";
         
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, a.getNome());
            stmt.setString(2, a.getSobrenome());
            stmt.setString(3, a.getTelefone()); 
            stmt.setString(4, a.getMatricula());
            stmt.execute();
            return true;
            
            
        } catch (SQLException ex) {
            
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
       
    }
    
    public boolean delete(Aluno a){
        String sql = "DELETE FROM Aluno WHERE matricula=?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, a.getMatricula());
            stmt.execute();
            return true;      
            
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
        
    }
    
    
    public List<Aluno> getList(){
        List<Aluno> aluno = new ArrayList<>();
        String sql = "SELECT * FROM Aluno";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();//Trazer dados
            while(rs.next()){
                Aluno a = new Aluno();
                a.setNome(rs.getString("pnome"));//esta string por parametro e o nome da coluna do banco
                a.setSobrenome(rs.getString("unome"));
                a.setTelefone(rs.getString("telefone"));
                a.setMatricula(rs.getString("matricula"));
                aluno.add(a);
            }
            stmt.close();
            rs.close();
            con.close();
            
        } catch (SQLException ex) {
            System.out.println("Erro lsita não retornada");
            return null;
        }    
        return aluno;
    }
    
}
