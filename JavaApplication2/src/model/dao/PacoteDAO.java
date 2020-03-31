
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.domain.Pacote;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.database.DatabasePostgreSQL;
import model.domain.Servico;



public class PacoteDAO {
	
  private Connection con;
    
    public PacoteDAO(){
        this.con = new DatabasePostgreSQL().conectar();
    }

	 
	 public boolean inserir(Pacote pacote) {
		 String sql = "INSERT INTO pacote(nome, preco, validade) VALUES(?,?,?)";
		 
		 try {
	            PreparedStatement stmt = con.prepareStatement(sql);
	            stmt.setString(1, pacote.getNome());
	            stmt.setFloat(2, pacote.getPreco());
	            stmt.setString(3, pacote.getValidade()); 
	            stmt.execute();
	            return true;
	        } catch (SQLException ex) {
	            Logger.getLogger(PacoteDAO.class.getName()).log(Level.SEVERE, null, ex);
	            return false;
	        }
 
		 
	 }

	 public List<Pacote> consultaPacotePessoa(String matricula){
		 	List<Pacote> pacotes = new ArrayList<>();
	    	String sql = "select  c.nomepacote, (c.dataFim - c.dataInicio) as tempo, pg.formaPagamento "
                        + "from pagamento pg, contrata c "
                        + "where c.matricula = pg.matricula and c.matricula = ?";
                System.out.println("0");
		 try {
			 PreparedStatement stmt = con.prepareStatement(sql);
                         stmt.setString(1, matricula);
                         System.out.println("1");
			 ResultSet st = stmt.executeQuery();
                         System.out.println("2");
                         
			 while(st.next()){
			 Pacote pacote = new Pacote();
                         System.out.println("3");
                         
			 pacote.setNome(st.getString("nomepacote")); 
                             System.out.println("Pacote: "+st.getString("nomepacote"));
			 pacote.setValidade(st.getString("formapagamento"));
                             System.out.println("Forma pagto: " +st.getString("formapagamento"));
			 pacote.setPreco(st.getInt("tempo"));
                             System.out.println("Tempo: "+st.getInt("tempo"));
			 pacotes.add(pacote);
                        
                             System.out.println("Pacote2: "+  pacotes.get(0).getNome());
                         //stmt.execute();
                             System.out.println("4");
			 }
                         
			 //stmt.close();
			// st.close();
			 con.close();
		 }
		 catch (SQLException ex){
                     
                     
			 System.out.println("ERRO");
                         System.out.println("Erro bd");
			 return null;
		 }
                 if(pacotes.size() == 0 ){
                 Pacote c = new Pacote();
                     c.setNome("0");
                     c.setPreco(0);
                     c.setValidade("0");
                     pacotes.add(c);
                 }
                 
		 return pacotes;
	 }
         
        public List<Servico> getList(String a){
        List<Servico> ser = new ArrayList<>();
        String sql = "SELECT s.nome FROM servicos s where s.id in (select c.id from contem c where c.nome = ?)";
       
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, a);
            stmt.execute();
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Servico s = new Servico();
                s.setNome(rs.getString("nome"));
              
                ser.add(s);
            }
            stmt.close();
            rs.close();
            con.close();
            
        } catch (SQLException ex) {
            System.out.println("Erro lsita não retornada");
            return null;
        }    
        return ser;
    }
        public Double getValor(String a){
             String sql = "Select p.preco from pacote p where p.nome = ?";
            Double v = 0.0;
            try{
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, a);
            stmt.execute();
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                v = rs.getDouble("preco");
                
            }
            stmt.close();
            rs.close();
            con.close();
            
        }catch (SQLException ex) {
            System.out.println("Erro lista não retornada");
            return 0.0;
        }    

             
            
            return v;
        }
    	 
}

