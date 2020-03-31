
package model.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.database.DatabasePostgreSQL;
import model.domain.Aluno;
import model.domain.Avaliacao_fisica;
import model.domain.Avaliacao_fisica;

public class Avaliacao_fisicaDAO {
    private Connection con;

   public Avaliacao_fisicaDAO(){
       this.con = new DatabasePostgreSQL().conectar();
   }

    public boolean inserir(Avaliacao_fisica avaliacao) {
        String sql = "INSERT INTO avalicaofisica(matricula, cpf, altura, objetivoaluno, totalgordura, peso, " +
                "dobratricipical, dobrasubescapular, dobraaxiliarmedia, dobraabdominal, dobracoxa, dobrapeitoral, " +
                "dobraSupraIliaca, circunferenciaTorax, circunferenciaQuadril, circunferenciaCintura, " +
                "circunferenciaabdomen, circunferenciacoxadir, circunferenciacoxaesq, circunferenciabracodir, " +
                "circunferenciabracoesq) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        System.out.println("1");

        try {
            System.out.println("1.5");
            PreparedStatement stmt = con.prepareStatement(sql);
            System.out.println("1.75");
            stmt.setString(1, avaliacao.getMatricula());
            stmt.setString(2, avaliacao.getCpf());
            stmt.setDouble(3, avaliacao.getAltura());
            stmt.setString(4, avaliacao.getObjetivoAluno()); 
            stmt.setDouble(5, avaliacao.getTotalGordura());
            stmt.setDouble(6, avaliacao.getPeso());
            stmt.setDouble(7, avaliacao.getDobraTricipical());
            stmt.setDouble(8, avaliacao.getDobraSubescapular());
            stmt.setDouble(9, avaliacao.getDobraAxiliarMedia());
            stmt.setDouble(10, avaliacao.getDobraAbdominal());
            stmt.setDouble(11, avaliacao.getDobraCoxa());
            stmt.setDouble(12, avaliacao.getDobraPeitoral());
            stmt.setDouble(13, avaliacao.getDobraSupraIliaca());
            stmt.setDouble(14, avaliacao.getCircunferenciaTorax());
            stmt.setDouble(15, avaliacao.getCircunferenciaQuadril());
            stmt.setDouble(16, avaliacao.getCircunferenciaCintura());
            stmt.setDouble(17, avaliacao.getCircunferenciaAbdomen());
            stmt.setDouble(18, avaliacao.getCircunferenciaCoxaDir());
            stmt.setDouble(19, avaliacao.getCircunferenciaCoxaEsq());
            stmt.setDouble(20, avaliacao.getCircunferenciaBracoDir());
            stmt.setDouble(21, avaliacao.getCircunferenciaBracoEsq());
            stmt.execute();
            System.out.println("2");
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir");
            Logger.getLogger(Avaliacao_fisicaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        }

        public List <Avaliacao_fisica> getAvaliacoes(String matricula){
            List<Avaliacao_fisica> avaliacaoFisica = new ArrayList<>();
            //String sql = "select * from avalicaofisica where matricula = ?";
              String sql = "select a.* from avalicaofisica a, aluno al "
                      + "where a.matricula = al.matricula and al.matricula =? group by a.data, a.matricula, a.numAvaliacao"
                      + " having a.data = (select max(a1.data) from avalicaofisica a1, aluno al1 "
                      + "where a1.matricula = al1.matricula and al1.matricula =?)";
            
            try {
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, matricula);
                stmt.setString(2, matricula); //alterei
                
                System.out.println("Passou");
                ResultSet st = stmt.executeQuery();
                System.out.println("Passou");
                 while (st.next()){
                     Avaliacao_fisica af = new Avaliacao_fisica();
                     af.setMatricula(st.getString("matricula"));
                       
                     af.setData(st.getString("data"));
                     
                     af.setNumAvaliacao(st.getInt("numavaliacao"));
                     af.setCpf(st.getString("cpf"));
                     af.setAltura(st.getFloat("altura"));
                     af.setObjetivoAluno(st.getString("objetivoaluno"));
                     af.setTotalGordura(st.getFloat("totalgordura"));
                     
                     
                     af.setPeso(st.getFloat("peso"));
                     af.setDobraTricipical(st.getFloat("dobratricipical"));
                     af.setDobraSubescapular(st.getFloat("dobrasubescapular"));
                   
                     af.setDobraAxiliarMedia(st.getFloat("dobraaxiliarmedia"));
                     af.setDobraAbdominal(st.getFloat("dobraabdominal"));
                     af.setDobraCoxa(st.getFloat("dobracoxa"));
                     
                     
                     af.setDobraPeitoral(st.getFloat("dobrapeitoral"));
                     af.setDobraSupraIliaca(st.getFloat("dobrasuprailiaca"));
                      
                     af.setCircunferenciaTorax(st.getFloat("circunferenciatorax"));
                     af.setCircunferenciaQuadril(st.getFloat("circunferenciaquadril"));
                     af.setCircunferenciaCintura(st.getFloat("circunferenciacintura"));
                     af.setCircunferenciaAbdomen(st.getFloat("circunferenciaabdomen"));
                     af.setCircunferenciaCoxaDir(st.getFloat("circunferenciacoxadir"));
                     af.setCircunferenciaCoxaEsq(st.getFloat("circunferenciacoxaesq"));
                     af.setCircunferenciaBracoDir(st.getFloat("circunferenciabracodir"));
                     af.setCircunferenciaBracoEsq(st.getFloat("circunferenciabracoesq"));
                     avaliacaoFisica.add(af);
                    // System.out.println("Passou com circunferencia" +avaliacaoFisica.get(0).getCircunferenciaAbdomen());
                     
                 }
                 //stmt.close();
                 // st.close();
                  con.close();
            }
            catch (SQLException ex){
                System.out.println("ERRO");
                return null;
            }
             if(avaliacaoFisica.size() == 0 ){
                 Avaliacao_fisica a = new Avaliacao_fisica();
                    a.setCircunferenciaAbdomen(0);
                    a.setCircunferenciaBracoDir(0);
                    a.setCircunferenciaBracoEsq(0);
                    a.setCircunferenciaCintura(0);
                    a.setCircunferenciaCoxaDir(0);
                    a.setCircunferenciaCoxaEsq(0);
                    a.setCircunferenciaQuadril(0);
                    a.setCircunferenciaTorax(0);
                    a.setDobraAbdominal(0);
                    a.setDobraAxiliarMedia(0);
                    a.setDobraCoxa(0);
                    a.setDobraPeitoral(0);
                    a.setDobraSubescapular(0);
                    a.setDobraSupraIliaca(0);
                    a.setDobraTricipical(0);
                    
                     avaliacaoFisica.add(a);
                 }
            return avaliacaoFisica;
        }


        public List<Avaliacao_fisica> getAvaliacaoData(String matricula, String dia, String mes, String ano){
            String sql = "select * from AvalicaoFisica where data='"+ano+"-"+mes+"-"+dia+"' and matricula = "+matricula;
            List<Avaliacao_fisica> avaliacaoFisica = new ArrayList<>();
            try {
                PreparedStatement stmt = con.prepareStatement(sql);
                ResultSet st = stmt.executeQuery();
                Avaliacao_fisica af = new Avaliacao_fisica();
                af.setMatricula(st.getString("Matricula"));
                af.setData(st.getString("Data"));
                af.setNumAvaliacao(st.getInt("numAvaliacao"));
                af.setCpf(st.getString("cpf"));
                af.setAltura(st.getFloat("altura"));
                af.setObjetivoAluno(st.getString("objetivoAluno"));
                af.setTotalGordura(st.getFloat("totalGordura"));
                af.setPeso(st.getFloat("peso"));
                af.setDobraTricipical(st.getFloat("dobraTricipical"));
                af.setDobraSubescapular(st.getFloat("dobraTricipical"));
                af.setDobraAxiliarMedia(st.getFloat("obraAxiliarMedia"));
                af.setDobraAbdominal(st.getFloat("dobraAbdominal"));
                af.setDobraCoxa(st.getFloat("dobraCoxa"));
                af.setDobraPeitoral(st.getFloat("dobraPeitoral"));
                af.setDobraSupraIliaca(st.getFloat("dobraSupraIliaca"));
                af.setCircunferenciaTorax(st.getFloat("circunferenciaTorax"));
                af.setCircunferenciaQuadril(st.getFloat("circunferenciaQuadril"));
                af.setCircunferenciaCintura(st.getFloat("circunferenciaCintura"));
                af.setCircunferenciaAbdomen(st.getFloat("circunferenciaAbdomen"));
                af.setCircunferenciaCoxaDir(st.getFloat("circunferenciaCoxaDir"));
                af.setCircunferenciaCoxaEsq(st.getFloat("circunferenciaCoxaEsq"));
                af.setCircunferenciaBracoDir(st.getFloat("circunferenciaBracoDir"));
                af.setCircunferenciaBracoEsq(st.getFloat("circunferenciaBracoEsq"));
                avaliacaoFisica.add(af);
                stmt.close();
                st.close();
                con.close();
            }
            catch (SQLException ex){
                System.out.println("ERRO");
                return null;
            }
            return avaliacaoFisica;
        }

        public List<Avaliacao_fisica> getUltimaAvaliacao(String matricula){
            String sql = "select  * from    avalicaofisica a where   a.matricula = "+matricula+"group by a.data, a" +
                    ".matricula, a.numAvaliacao having  a.data = (select max(a1.data) from" +
                    "avalicaofisica a1 where   a1.matricula = "+matricula+")";
            List<Avaliacao_fisica> avaliacaoFisica = new ArrayList<>();
            try {
                PreparedStatement stmt = con.prepareStatement(sql);
                ResultSet st = stmt.executeQuery();
                
                Avaliacao_fisica af = new Avaliacao_fisica();
                
                af.setMatricula(st.getString("Matricula"));
                af.setData(st.getString("Data"));
                af.setNumAvaliacao(st.getInt("numAvaliacao"));
                af.setCpf(st.getString("cpf"));
                af.setAltura(st.getFloat("altura"));
                af.setObjetivoAluno(st.getString("objetivoAluno"));
                af.setTotalGordura(st.getFloat("totalGordura"));
                af.setPeso(st.getFloat("peso"));
                af.setDobraTricipical(st.getFloat("dobraTricipical"));
                af.setDobraSubescapular(st.getFloat("dobraTricipical"));
                af.setDobraAxiliarMedia(st.getFloat("obraAxiliarMedia"));
                af.setDobraAbdominal(st.getFloat("dobraAbdominal"));
                af.setDobraCoxa(st.getFloat("dobraCoxa"));
                af.setDobraPeitoral(st.getFloat("dobraPeitoral"));
                af.setDobraSupraIliaca(st.getFloat("dobraSupraIliaca"));
                af.setCircunferenciaTorax(st.getFloat("circunferenciaTorax"));
                af.setCircunferenciaQuadril(st.getFloat("circunferenciaQuadril"));
                af.setCircunferenciaCintura(st.getFloat("circunferenciaCintura"));
                af.setCircunferenciaAbdomen(st.getFloat("circunferenciaAbdomen"));
                af.setCircunferenciaCoxaDir(st.getFloat("circunferenciaCoxaDir"));
                af.setCircunferenciaCoxaEsq(st.getFloat("circunferenciaCoxaEsq"));
                af.setCircunferenciaBracoDir(st.getFloat("circunferenciaBracoDir"));
                af.setCircunferenciaBracoEsq(st.getFloat("circunferenciaBracoEsq"));
                avaliacaoFisica.add(af);
                stmt.close();
                st.close();
                con.close();
            }
            catch (SQLException ex){
                System.out.println("ERRO");
                return null;
            }
            return avaliacaoFisica;
        }
        
        public boolean delete(Aluno a){
            String sql = "DELETE FROM avalicaofisica WHERE matricula=?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, a.getMatricula());
            stmt.execute();
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(Avaliacao_fisicaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
            
            
        }

    }

