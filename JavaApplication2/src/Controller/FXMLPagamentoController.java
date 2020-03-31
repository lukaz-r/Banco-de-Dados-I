/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import hellofx.ConsultaPlano;
import hellofx.Pagamento1;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.dao.AlunoDAO;
import model.dao.PagamentoDAO;
import model.domain.Aluno;
import model.domain.Pagamento;

/**
 * FXML Controller class
 *
 * @author CUZIM
 */
public class FXMLPagamentoController implements Initializable {

    @FXML
    private TableView<Aluno> TabelaAluno;
    @FXML
    private TableColumn<Aluno, String> clnAluno;
    @FXML
    private TableColumn<Aluno, String> clnMatricula;
    @FXML
    private ComboBox<String> ComboBox;
    @FXML
    private Button buttonAdicionar;
    @FXML
    private Button buttonCancelar;
    private Aluno alunoSel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        initTableAluno();
        CarregaComboBox();
        TabelaAluno.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue ov, Object t, Object t1) {
               alunoSel = (Aluno) t1;
                
            }
        });
        
        buttonCancelar.setOnMouseClicked((MouseEvent e)->{
            fecha();
        
        });
        buttonAdicionar.setOnMouseClicked((MouseEvent e)->{
           addPagamento(alunoSel);
        
        });
        
        
 
        
    }    
    public void initTableAluno(){
        clnAluno.setCellValueFactory(new PropertyValueFactory("nome"));        
        clnMatricula.setCellValueFactory(new PropertyValueFactory("matricula"));
        TabelaAluno.setItems(atualizaTabela1());
    }
    
    public ObservableList<Aluno> atualizaTabela1(){
        AlunoDAO dao = new AlunoDAO();
        return FXCollections.observableArrayList(dao.getList());
    }
    
    public void fecha(){
     Pagamento1.getStage().close();
    }
    public void addPagamento(Aluno alu){
        
        String nomeP = ComboBox.getSelectionModel().getSelectedItem();
        String matricula = alu.getMatricula();
        //String valor = txValor.getText();
                
        
        Pagamento p = new Pagamento();
        p.setForma(nomeP);
        p.setMatricula(matricula);
        //p.setValor(Float.parseFloat(valor));
        PagamentoDAO dao = new PagamentoDAO();
        
        
        if(dao.inserir(p)){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText("Aluno Cadastrado");
                alert.show();
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Erro Banco de dados");
                alert.setTitle("Erro ao inserir");
                alert.setContentText("Aluno não cadastrado");
                alert.show();
            }
    }
    public void CarregaComboBox(){
       ArrayList<String> p = new ArrayList<>();
       p.add("Cartão de Credito");
       p.add("Dinheiro");
       p.add("Cheque");
       p.add("PicPay");
       p.add("Débito");
       
       ObservableList<String> op = FXCollections.observableArrayList(p);
       ComboBox.setItems(op);
      
       
    }
}
