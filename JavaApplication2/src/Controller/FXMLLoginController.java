/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import hellofx.Base;
import hellofx.Login;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.dao.FuncionarioDAO;
import model.domain.Funcionario;

/**
 * FXML Controller class
 *
 * @author CUZIM
 */
public class FXMLLoginController implements Initializable {

    @FXML
    private TextField textfieldCPF;
    private TextField textfieldSenha;
    @FXML
    private Button BotaoLogar;
    @FXML
    private PasswordField pwfSenha;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        BotaoLogar.setOnMouseClicked((MouseEvent e) -> {
            FuncionarioDAO dao = new FuncionarioDAO();
            List<Funcionario> funcionario = dao.getList();

            for (int i = 0; i < funcionario.size(); i++) {
                if (textfieldCPF.getText().equals(funcionario.get(i).getNome()) && pwfSenha.getText().equals(funcionario.get(i).getCref())) {
                    Base b = new Base();
                    i = funcionario.size();
                    try {
                        b.start(new Stage());
                       
                    } catch (Exception ex) {
                        Logger.getLogger(FXMLLoginController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                } else {
                    if(i == funcionario.size() - 1){
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setHeaderText("Erro no Login");
                    alert.setTitle("Login Invalido");
                    alert.setContentText("Usuario e/ou senha invalido");
                    alert.show();
                    }
                }
            }
            
        });
        //fecha();
    }

    @FXML
    private void botaoLogarmet(ActionEvent event) {

    }

    public void fecha() {
        Login.getStage().close();
    }

}
