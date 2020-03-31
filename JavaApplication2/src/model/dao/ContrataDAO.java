/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import hellofx.Contrata1;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.database.DatabasePostgreSQL;
import model.domain.Servico;

import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.domain.Aluno;
import model.domain.Contrata;

public class ContrataDAO {

    private Connection con;

    public ContrataDAO() {
        this.con = new DatabasePostgreSQL().conectar();
    }

    public boolean inserir(Contrata contrata) {
        String sql = "INSERT INTO contrata(matricula, nomepacote, dataFim) VALUES (?,?,?)";

        try {
            SimpleDateFormat f = new SimpleDateFormat("yyy-MM-dd");
            Date parsed = f.parse(contrata.getDataFim());
            java.sql.Date sql2 = new java.sql.Date(parsed.getTime());

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, contrata.getMatricula());
            stmt.setString(2, contrata.getNomePacote());
            stmt.setDate(3, sql2);
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ContrataDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (ParseException ex) {
            Logger.getLogger(ContrataDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public List<Servico> getServicos(String nomePacote) {
        List<Servico> servicos = new ArrayList<>();
        String sql = "select  s.nome, s.id from servicos s where s.id in(select c.id from contem c where c.nome =" + nomePacote + ")";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet st = stmt.executeQuery();
            while (st.next()) {
                Servico servico = new Servico();
                servico.setNome(st.getString("nome"));
                servico.setId(st.getInt("id"));
                servicos.add(servico);
            }
            stmt.close();
            st.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println("ERRO");
            return null;
        }
        return servicos;
    }

    public boolean delete(Aluno a) {
        String sql = "DELETE FROM contrata WHERE matricula=?";
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
