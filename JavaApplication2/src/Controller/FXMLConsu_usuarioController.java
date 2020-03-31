/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import hellofx.ConsultaUsuario;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.domain.Aluno;
import model.domain.Funcionario;
import model.dao.AlunoDAO;
import model.dao.FuncionarioDAO;
/**
 * FXML Controller class
 *
 * @author CUZIM
 */
public class FXMLConsu_usuarioController implements Initializable {

    @FXML
    private TableColumn<Aluno, String> clnAlunoNome;
    @FXML
    private TableColumn<Aluno, String> clnAlunoSobrenome;
    @FXML
    private TableColumn<Aluno, String> clnAlunoMatricula;
    @FXML
    private TableColumn<Aluno, String> clnAlunoTelefone;
    @FXML
    private Button onButtonRemoveAluno;
    @FXML
    private Button onButtonCancelar;
    @FXML
    private TableColumn<Funcionario, String> clnFuncionarioNome;
    @FXML
    private TableColumn<Funcionario, String> clnFuncionarioSobrenome;
    @FXML
    private TableColumn<Funcionario, String> clnFuncionarioCPF;
    @FXML
    private TableColumn<Funcionario, String> clnFuncionarioCREF;
    @FXML
    private Button onButtonDemitiFunc;
    @FXML
    private TableView<Aluno> TabelaAluno;
    @FXML
    private TableView<Funcionario> tabelaFunc;
    private Aluno alunoSel;
    private Funcionario funcionarioSel;
    


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initTableAluno();
        initTableFuncionario();
        onButtonCancelar.setOnMouseClicked((MouseEvent e)->{
            fecha();
        
        });
        
                
       onButtonRemoveAluno.setOnMouseClicked((MouseEvent e)->{
            deletaAluno();
        
        });
       onButtonDemitiFunc.setOnMouseClicked((MouseEvent e)->{
            deletaFuncionario();
        
        });
                
        TabelaAluno.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue ov, Object t, Object t1) {
               alunoSel = (Aluno) t1;
                
            }
        });
        
        tabelaFunc.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue ov, Object t, Object t1) {
                funcionarioSel = (Funcionario) t1;
                
            }
        });
        
    }  
    
    
    
    
    public void initTableAluno(){
        clnAlunoNome.setCellValueFactory(new PropertyValueFactory("nome"));
        clnAlunoSobrenome.setCellValueFactory(new PropertyValueFactory("sobrenome"));
        clnAlunoMatricula.setCellValueFactory(new PropertyValueFactory("matricula"));
        clnAlunoTelefone.setCellValueFactory(new PropertyValueFactory("telefone"));
        TabelaAluno.setItems(atualizaTabela1());
    }
    
    public void initTableFuncionario(){
        clnFuncionarioNome.setCellValueFactory(new PropertyValueFactory("nome"));
        clnFuncionarioSobrenome.setCellValueFactory(new PropertyValueFactory("sobrenome"));
        clnFuncionarioCPF.setCellValueFactory(new PropertyValueFactory("cpf"));
        clnFuncionarioCREF.setCellValueFactory(new PropertyValueFactory("cref"));
        tabelaFunc.setItems(atualizaTabela2());
    }
    
    public ObservableList<Aluno> atualizaTabela1(){
        AlunoDAO dao = new AlunoDAO();
        return FXCollections.observableArrayList(dao.getList());
    }
    
    public ObservableList<Funcionario> atualizaTabela2(){
        FuncionarioDAO dao = new FuncionarioDAO();
        return FXCollections.observableArrayList(dao.getList());
    }
    
    public void fecha(){
        ConsultaUsuario.getStage().close();
    }
    
    public void deletaAluno(){
        if(alunoSel != null ){
        AlunoDAO dao = new AlunoDAO();
        dao.delete(alunoSel);
            Alert a = new Alert(AlertType.CONFIRMATION);
            a.setHeaderText("Aluno Removido");
            a.show();
            TabelaAluno.setItems(atualizaTabela1());
        }else{
            Alert a = new Alert(AlertType.WARNING);
            a.setHeaderText("Selecione um Aluno");
            a.show();
        }
        
    }
    public void deletaFuncionario(){
        if(funcionarioSel != null){
        FuncionarioDAO dao = new FuncionarioDAO();
        dao.delete(funcionarioSel);
            Alert a = new Alert(AlertType.CONFIRMATION);
            a.setHeaderText("Funcionario Removido");
            a.show();
            tabelaFunc.setItems(atualizaTabela2());
        }else{
            Alert a = new Alert(AlertType.WARNING);
            a.setHeaderText("Selecione um Funcionario");
            a.show();
        }
    }
    
    
    
}
