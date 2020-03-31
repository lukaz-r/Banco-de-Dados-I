
package model.dao;

import java.sql.Connection;
import model.domain.Funcionario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.database.DatabasePostgreSQL;
import model.domain.Aluno;


public class FuncionarioDAO {
    private final Connection con;
    
    
    public FuncionarioDAO(){
        this.con = new DatabasePostgreSQL().conectar();
    }
    
    public boolean add(Funcionario f){
        String sql = "INSERT INTO  Funcionario(pnome, unome, cpf, cref) values(?,?,?,?)";
         
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, f.getNome());
            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getSobrenome());
            stmt.setString(3, f.getCpf());
            stmt.setString(4, f.getCref());
            stmt.execute();
            return true;


            DELETE FROM Funcionario WHERE cpf=?
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
       
    }

    
    public boolean delete(Funcionario f){
        String sql = "";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, f.getCpf());
            stmt.execute();
            return true;      
            
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    
    public List<Funcionario> getList(){
        List<Funcionario> funcionario = new ArrayList<>();
        String sql = "SELECT * FROM funcionario";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();//Trazer dados
            while(rs.next()){
                
                Funcionario f = new Funcionario();
                f.setNome(rs.getString("pnome"));//esta string por parametro e o nome da coluna do banco
                f.setSobrenome(rs.getString("unome"));
                f.setCpf(rs.getString("cpf"));
                f.setCref(rs.getString("cref"));
              
                funcionario.add(f);
            }
            stmt.close();
            rs.close();
            con.close();
            
        } catch (SQLException ex) {
            System.out.println("Erro lista não retornada");
            return null;
        }    
        return funcionario;
    }
        
    
    
}
