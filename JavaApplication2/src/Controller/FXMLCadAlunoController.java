/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import hellofx.CadastrarAluno;
import hellofx.ConsultaUsuario;
import hellofx.Login;
import hellofx.PesquisaAvaliacao;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.dao.AlunoDAO;
import model.domain.Aluno;

/**
 * FXML Controller class
 *
 * @author CUZIM
 */
public class FXMLCadAlunoController implements Initializable {

    @FXML
    private Label LabelAlunoNome;
    @FXML
    private Label LabelAlunoSobrenome;
    @FXML
    private Label LabelAlunoMatricula;
    @FXML
    private Label LabelAlunoTelefone;
    @FXML
    private TextField TextFieldAlunoNome;
    @FXML
    private TextField TextFieldAlunoSobrenome;
    @FXML
    private TextField TextFieldAlunoMatricula;
    @FXML
    private TextField TextFieldAlunoTelefone;
    @FXML
    private Button ButtonConfirmar;
    @FXML
    private Button ButtonCancelar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    
    private void CadastraAluno(){
         String nome = TextFieldAlunoNome.getText(), 
                sobrenome = TextFieldAlunoSobrenome.getText(), 
                matricula = TextFieldAlunoMatricula.getText(), 
                telefone = TextFieldAlunoTelefone.getText();   
        
        Aluno a = new Aluno();
            a.setNome(nome);
            a.setSobrenome(sobrenome);
            a.setMatricula(matricula);
            a.setTelefone(telefone);
            AlunoDAO dao = new AlunoDAO();
            
            
            if(dao.add(a)){
                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setHeaderText("Aluno Cadastrado");
                alert.show();
            }else{
                Alert alert = new Alert(AlertType.ERROR);
                alert.setHeaderText("Erro Banco de dados");
                alert.setTitle("Erro ao inserir");
                alert.setContentText("Aluno não cadastrado");
                alert.show();
            }
    }
    
    
    
    
    public void listaAluno(){
        ConsultaUsuario c = new ConsultaUsuario();
        try {
           
            c.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(FXMLCadAlunoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
  
    
    
    @FXML
    private void handleButtonConfirmar(ActionEvent event) {
        CadastraAluno();
        fecha();
    }

    @FXML
    private void handleButtonCancelar(ActionEvent event) {
       fecha();
    }
    

    
    public void fecha(){
        CadastrarAluno.getStage().close();
    }
}
