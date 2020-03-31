/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import hellofx.CadastrarFuncionario;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.dao.AlunoDAO;
import model.dao.FuncionarioDAO;
import model.domain.Aluno;
import model.domain.Funcionario;

/**
 * FXML Controller class
 *
 * @author CUZIM
 */
public class FXMLCadFuncionarioController implements Initializable {

    @FXML
    private Label LabelFuncionarioNome;
    @FXML
    private Label LabelFuncionarioSobrenome;
    @FXML
    private Label LabelFuncionarioCPF;
    @FXML
    private Label LabelFuncionarioCREF;
    @FXML
    private TextField TextFieldFuncionarioNome;
    @FXML
    private TextField TextFieldFuncionarioSobrenome;
    @FXML
    private TextField TextFieldFuncionarioCPF;
    @FXML
    private TextField TextFieldFuncionarioCREF;
    @FXML
    private Button ButtonConfirmar;
    @FXML
    private Button ButtonCancelar;
    @FXML
    private Button ButtonAlternarAluno;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    
    
    
    private void CadastraFuncionario(){
        String nome = TextFieldFuncionarioNome.getText(),
                sobrenome = TextFieldFuncionarioSobrenome.getText(),
                cpf = TextFieldFuncionarioCPF.getText(),
                cref = TextFieldFuncionarioCREF.getText();
                
   
        Funcionario f = new Funcionario();
            f.setNome(nome);
            f.setSobrenome(sobrenome);
            f.setCpf(cpf);
            f.setCref(cref);
            FuncionarioDAO dao = new FuncionarioDAO();
            
            if(dao.add(f)){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText("Funcionario Cadastrado");
                alert.show();
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Erro Banco de dados");
                alert.setTitle("Erro ao inserir");
                alert.setContentText("Funcionario não cadastrado");
                alert.show();
            }
    }

    
    
    
    
    public void listaFuncionario(){
        System.out.println("Listando Funcionarios");
        List<Funcionario> funcionario = new FuncionarioDAO().getList();
        for(int i = 0; i < funcionario.size(); i++){
            funcionario.get(i).mostra();
        }
    }
    @FXML
    private void handleButtonConfirmar(ActionEvent event) {
        CadastraFuncionario();
        fecha();
    }

    @FXML
    private void handleButtonCancelar(ActionEvent event) {
        fecha();
    }

    @FXML
    private void handleButtonAlterna(ActionEvent event) {
    }
    public void fecha(){
        CadastrarFuncionario.getStage().close();
    }
}
