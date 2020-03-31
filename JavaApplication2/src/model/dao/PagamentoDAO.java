package model.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.database.DatabasePostgreSQL;
import java.sql.Connection;
import model.domain.Pagamento;


public class PagamentoDAO {
    
    
    private Connection con;
    
    
    public PagamentoDAO(){
        this.con = new DatabasePostgreSQL().conectar();
    };


    
    
    public boolean inserir(Pagamento pagamento) {
        String sql = "insert into pagamento(valor, formaPagamento, matricula) values   (?,?,?)";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setFloat(1, pagamento.getValor());
            stmt.setString(2, pagamento.getForma());
            stmt.setString(3, pagamento.getMatricula());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PagamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}

