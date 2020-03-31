/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import hellofx.ConsultaPlano;
import hellofx.Contrata1;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.dao.AlunoDAO;
import model.dao.Avaliacao_fisicaDAO;
import model.dao.ContrataDAO;
import model.dao.PacoteDAO;
import model.domain.Aluno;
import model.domain.Contrata;
import model.domain.Pacote;
import model.domain.Pagamento;

/**
 * FXML Controller class
 *
 * @author CUZIM
 */
public class FXMLConsu_PlanosController implements Initializable {

    @FXML
    private TableView<Aluno> TabelaAlunos;
    @FXML
    private TableColumn<Aluno, String> clnNome;
    @FXML
    private TableColumn<Aluno, String> clnMatricula;
    @FXML
    private Label lbPacote;
    @FXML
    private Label lbVallidade;
    @FXML
    private Label lbForma_pgto;
    private Button onButtonConsultar;
    @FXML
    private Button onButtonCancelar;
    private Aluno alunoSel;
    @FXML
    private Button onButtonRemover;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initTableAluno();
        onButtonCancelar.setOnMouseClicked((MouseEvent e) -> {
            fecha();

        });
        onButtonRemover.setOnMouseClicked((MouseEvent e) -> {
            ApagarPlano(alunoSel);
        });

        TabelaAlunos.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue ov, Object t, Object t1) {
                alunoSel = (Aluno) t1;
                ConsultaPlano(alunoSel);
;
            }
        });
    }

    public void initTableAluno() {
        clnNome.setCellValueFactory(new PropertyValueFactory("nome"));
        clnMatricula.setCellValueFactory(new PropertyValueFactory("matricula"));
        TabelaAlunos.setItems(atualizaTabela1());
    }

    public ObservableList<Aluno> atualizaTabela1() {
        AlunoDAO dao = new AlunoDAO();
        return FXCollections.observableArrayList(dao.getList());
    }

    public void fecha() {
        ConsultaPlano.getStage().close();
    }

    public void ConsultaPlano(Aluno a) {

        
        PacoteDAO dao = new PacoteDAO();
        List<Pacote> pact = dao.consultaPacotePessoa(a.getMatricula());
           Collections.reverse(pact);
        //System.out.println("Matricula:" +a.getMatricula());
        //System.out.println("Matricula" + pact.get(0).getNome());
      
  lbPacote.setText(pact.get(0).getNome());
  lbVallidade.setText(Float.toString(pact.get(0).getPreco()));
  lbForma_pgto.setText(pact.get(0).getValidade());
 
 //     System.out.println("Pacote: " +pact.get(0).getNome());
     

    }
    
    public void ApagarPlano(Aluno a){
        if(a != null){
            ContrataDAO dao = new ContrataDAO();
            dao.delete(a);
            Alert v = new Alert(Alert.AlertType.CONFIRMATION);            
            v.setHeaderText("Plano Removida");
            v.show();
            TabelaAlunos.setItems(atualizaTabela1());
        }
    }
    
}
