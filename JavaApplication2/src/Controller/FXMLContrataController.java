/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import hellofx.ConsultaUsuario;
import hellofx.Contrata1;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.dao.AlunoDAO;
import model.dao.ContrataDAO;
import model.dao.PacoteDAO;
import model.domain.Aluno;
import model.domain.Contrata;
import model.domain.Pacote;
import model.domain.Servico;

public class FXMLContrataController implements Initializable {

    @FXML
    private DatePicker dataValidade;
    @FXML
    private TableView<Aluno> TabelaContrato;
    @FXML
    private TableColumn<Aluno, String> clnNome;
    @FXML
    private TableColumn<Aluno, String> clnMatricula;
    @FXML
    private Button onButtonPacote;
    @FXML
    private Button onButtonCancelar;
    private Aluno alunoSel;
    private Pacote pacoteSel;
    @FXML
    private ComboBox<String> ComboBox;
    @FXML
    private TableView<Servico> tbServicos;
    @FXML
    private TableColumn<Servico, String> clnServicos;
    @FXML
    private Button buttonServico;
    @FXML
    private Label lbValor;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initTableAluno();
        CarregaComboBox();
        TabelaContrato.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue ov, Object t, Object t1) {
                alunoSel = (Aluno) t1;
                
            }
        });
        
        
        onButtonCancelar.setOnMouseClicked((MouseEvent e) -> {
            
           
            fecha();
        });
        
        buttonServico.setOnMouseClicked((MouseEvent e) -> {
              initTableAlunoServico();
             String a = "R$: "+ pegarValor();           
              lbValor.setText(a);
        });
       

        onButtonPacote.setOnMouseClicked((MouseEvent e) -> {
            addPacote(alunoSel);
            

        });

    }

    public void initTableAluno() {
        clnNome.setCellValueFactory(new PropertyValueFactory("nome"));
        clnMatricula.setCellValueFactory(new PropertyValueFactory("matricula"));
        TabelaContrato.setItems(atualizaTabela1());
    }
    public void initTableAlunoServico() {
        clnServicos.setCellValueFactory(new PropertyValueFactory("nome"));
        tbServicos.setItems(atualizaTabela());
    }

    public ObservableList<Aluno> atualizaTabela1() {
        AlunoDAO dao = new AlunoDAO();
        return FXCollections.observableArrayList(dao.getList());
    }
    
    public ObservableList<Servico> atualizaTabela(){
        return FXCollections.observableArrayList(listaServico());
    }

    public void fecha() {
        Contrata1.getStage().close();
    }

    public void addPacote(Aluno alu) {
        
        
        String dataFormat = dataValidade.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String nomeP = ComboBox.getSelectionModel().getSelectedItem();
        String matricula = alu.getMatricula();

        Contrata c = new Contrata();
        c.setMatricula(matricula);
        c.setNomePacote(nomeP);
        c.setDataFim(dataFormat);

        ContrataDAO dao = new ContrataDAO();

        if (dao.inserir(c)) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("Pacote Cadastrado");
            alert.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Erro Banco de dados");
            alert.setTitle("Erro ao inserir");
            alert.setContentText("Pacote não cadastrado");
            alert.show();
        }

        System.out.println("Pacote: " + c.getNomePacote());
        System.out.println("matricula: " + c.getMatricula());
        System.out.println("Data: " + c.getDataFim());

    }

    public void CarregaComboBox() {
        ArrayList<String> p = new ArrayList<>();
        p.add("Monster");
        p.add("Brill");
        p.add("fitness");
        ObservableList<String> op = FXCollections.observableArrayList(p);
        ComboBox.setItems(op);

    }
    public List<Servico> listaServico(){
       String nomeP1 = ComboBox.getSelectionModel().getSelectedItem();
       PacoteDAO dao = new PacoteDAO();
       
       List<Servico> a = dao.getList(nomeP1);
        System.out.println("TEsta: "+ a.get(0).getNome());
        return a;
      
    }
    
    public Double pegarValor(){
        String nomeP2 = ComboBox.getSelectionModel().getSelectedItem();
        PacoteDAO dao = new PacoteDAO();
    
        return dao.getValor(nomeP2);
       
    }
}
