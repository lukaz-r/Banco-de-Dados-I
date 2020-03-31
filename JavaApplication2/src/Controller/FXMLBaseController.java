/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import hellofx.AtualizaAvaliacao;
import hellofx.CadastrarAluno;
import hellofx.CadastrarFuncionario;
import hellofx.ConsultaPlano;
import hellofx.ConsultaUsuario;
import hellofx.PesquisaAvaliacao;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import hellofx.Contrata1;
import hellofx.Pagamento1;

public class FXMLBaseController implements Initializable {

    @FXML
    private MenuItem miCadAluno;
    @FXML
    private MenuItem miCadFunc;
    @FXML
    private MenuItem miAtualizaAva;
    @FXML
    private MenuItem miConsAva;
    @FXML
    private MenuItem miConsuUsuario;
    @FXML
    private MenuItem miCadasPac;
    @FXML
    private MenuItem miConsultPac;
    @FXML
    private MenuItem miFromaPac;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void onClickedmiCadAluno(ActionEvent event) {
        CadastrarAluno a = new CadastrarAluno();
        try {
            a.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(FXMLBaseController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void onClickedmiCadFunc(ActionEvent event) {
        CadastrarFuncionario f = new CadastrarFuncionario();
        try {
            f.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(FXMLBaseController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void onClickedmiAtualizaAva(ActionEvent event) {
        AtualizaAvaliacao a = new AtualizaAvaliacao();
        try {
            a.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(FXMLBaseController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void onClickedmimiConsAva(ActionEvent event) {
        PesquisaAvaliacao p = new PesquisaAvaliacao();
        try {
            p.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(FXMLBaseController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void omClickedmiConsuUsuario(ActionEvent event) {
        ConsultaUsuario c = new ConsultaUsuario();
        try {
            c.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(FXMLBaseController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void onClickedConsulta(ActionEvent event) {
        ConsultaPlano c = new ConsultaPlano();
        try {
            c.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(FXMLBaseController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void onClickedFormaPgto(ActionEvent event) {
        Pagamento1 p = new Pagamento1();
        try {
            p.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(FXMLBaseController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void onContrata(ActionEvent event) {
        Contrata1 c = new Contrata1();
        try {
            c.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(FXMLBaseController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
