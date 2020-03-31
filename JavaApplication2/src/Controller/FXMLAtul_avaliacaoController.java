/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import hellofx.AtualizaAvaliacao;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.dao.AlunoDAO;
import model.dao.Avaliacao_fisicaDAO;
import model.domain.Aluno;
import model.domain.Avaliacao_fisica;

/**
 * FXML Controller class
 *
 * @author CUZIM
 */
public class FXMLAtul_avaliacaoController implements Initializable {

    @FXML
    private TextField txc1;
    @FXML
    private TextField txc2;
    @FXML
    private TextField txc3;
    @FXML
    private TextField txc4;
    @FXML
    private TextField txc5;
    @FXML
    private TextField txc6;
    @FXML
    private TextField txc7;
    @FXML
    private TextField txc8;
    @FXML
    private TextField txd2;
    @FXML
    private TextField txd3;
    @FXML
    private TextField txd1;
    @FXML
    private TextField txd6;
    @FXML
    private TextField txd4;
    @FXML
    private TextField txd5;
    @FXML
    private TextField txmatricula;
    @FXML
    private TextField txcpf;
    @FXML
    private TextField txobjetivo;
    @FXML
    private TextField txaltura;
    @FXML
    private TextField txpeso;
    @FXML
    private TextField txgordura;
    @FXML
    private TextField txd7;
    @FXML
    private TableView<Aluno> TabelaAluno;
    @FXML
    private TableColumn<Aluno, String> lbNome;
    @FXML
    private TableColumn<Aluno, String> lbMatricula;
    @FXML
    private Button onButtonInserir;
    private Aluno alunoSel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initTableAluno();

        TabelaAluno.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue ov, Object t, Object t1) {
                alunoSel = (Aluno) t1;

            }
        });

        onButtonInserir.setOnMouseClicked((MouseEvent e) -> {
            CadastrarAvaliacao();
        });

    }

    public void initTableAluno() {
        lbNome.setCellValueFactory(new PropertyValueFactory("nome"));
        lbMatricula.setCellValueFactory(new PropertyValueFactory("matricula"));
        TabelaAluno.setItems(atualizaTabela1());
    }

    public ObservableList<Aluno> atualizaTabela1() {
        AlunoDAO dao = new AlunoDAO();
        return FXCollections.observableArrayList(dao.getList());
    }

  

    public void CadastrarAvaliacao() {
        String matricula = txmatricula.getText(),
                cpf = txcpf.getText(),
                objetivo = txobjetivo.getText();

        double altura = Double.parseDouble(txaltura.getText()),
                totalGordura = Double.parseDouble(txgordura.getText()),
                peso = Double.parseDouble(txpeso.getText()),
                tricipical = Double.parseDouble(txd1.getText()),
                subescapular = Double.parseDouble(txd2.getText()),
                axiliarmedia = Double.parseDouble(txd3.getText()),
                abdominal = Double.parseDouble(txd4.getText()),
                coxa = Double.parseDouble(txd5.getText()),
                peitoral = Double.parseDouble(txd6.getText()),
                suprailiaca = Double.parseDouble(txd7.getText()),
                torax = Double.parseDouble(txc1.getText()),
                quadril = Double.parseDouble(txc2.getText()),
                cintura = Double.parseDouble(txc3.getText()),
                abdomen = Double.parseDouble(txc4.getText()),
                coxadir = Double.parseDouble(txc5.getText()),
                coxaesq = Double.parseDouble(txc6.getText()),
                bracodir = Double.parseDouble(txc7.getText()),
                bracoesq = Double.parseDouble(txc8.getText());

        Avaliacao_fisica a = new Avaliacao_fisica();
        a.setMatricula(matricula);
        a.setCpf(cpf);
        a.setAltura(altura);
        a.setObjetivoAluno(objetivo);
        a.setTotalGordura(totalGordura);
        a.setPeso(peso);
        a.setDobraTricipical(tricipical);
        a.setDobraSubescapular(subescapular);
        a.setDobraAxiliarMedia(axiliarmedia);
        a.setDobraAbdominal(abdominal);
        a.setDobraCoxa(coxa);
        a.setDobraPeitoral(peitoral);
        a.setDobraSupraIliaca(suprailiaca);
        a.setCircunferenciaTorax(torax);
        a.setCircunferenciaQuadril(quadril);
        a.setCircunferenciaCintura(cintura);
        a.setCircunferenciaAbdomen(abdomen);
        a.setCircunferenciaCoxaDir(coxadir);
        a.setCircunferenciaCoxaEsq(coxaesq);
        a.setCircunferenciaBracoDir(bracodir);
        a.setCircunferenciaBracoEsq(bracoesq);
        
        Avaliacao_fisicaDAO dao = new Avaliacao_fisicaDAO();
        

        if (alunoSel != null) {
            if (alunoSel.getMatricula().equals(matricula)) {

                if (dao.inserir(a)) {
                    Alert alert = new Alert(AlertType.CONFIRMATION);
                    alert.setHeaderText("Avaliacao Cadastrado");
                    alert.show();
                    fecha();
                } else {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setHeaderText("Erro Banco de dados");
                    alert.setTitle("Erro ao inserir");
                    alert.setContentText("avaliacao não cadastrado");
                    alert.show();

                }
            } else {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setHeaderText("Erro Banco de dados");
                alert.setTitle("Erro ao inserir");
                alert.setContentText("Aluno nao corresponde ao avaliado");
                alert.show();
            }
        }else{
             Alert alert = new Alert(AlertType.WARNING);
                alert.setHeaderText("Erro Banco de dados");
                alert.setTitle("Erro ao inserir");
                alert.setContentText("Selecione Aluno");
                alert.show();
        }
        
    }

    @FXML
    private void onClickedButtonInserirDados(ActionEvent event) {

    }
    
    public void fecha(){
        AtualizaAvaliacao.getStage().close();
    }
}
