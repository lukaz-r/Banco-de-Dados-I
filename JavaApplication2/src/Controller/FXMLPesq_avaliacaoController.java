package Controller;

import hellofx.PesquisaAvaliacao;
import java.net.URL;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
public class FXMLPesq_avaliacaoController implements Initializable {

    @FXML
    private SplitPane TabelaAluno;
    @FXML
    private TableColumn<Aluno, String> clnNome;
    @FXML
    private TableColumn<Aluno, String> clnMatricula;
    @FXML
    private TableView<Aluno> TabelaAluno1;
    @FXML
    private Label lbTorax;
    @FXML
    private Label lbQuadril;
    @FXML
    private Label lbCintura;
    @FXML
    private Label lbAbdomen;
    @FXML
    private Label lbCoxaD;
    @FXML
    private Label lbCoxaE;
    @FXML
    private Label lbBracoD;
    @FXML
    private Label lbBracoE;
    @FXML
    private Label lbTricipical;
    @FXML
    private Label lbSubescapular;
    @FXML
    private Label lbAxMed;
    @FXML
    private Label lbAbdominal;
    @FXML
    private Label lbCoxa;
    @FXML
    private Label lbPeitoral;
    @FXML
    private Label lbSupa;
    @FXML
    private Label lbGordura;

    @FXML
    private Label lbObjetivo;

    @FXML
    private Label lbPeso;

    @FXML
    private Label lbCPF;

    @FXML
    private Label lbAltura;
    private Aluno alunoSel;
    @FXML
    private Button buttonRemove;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initTableAluno();

        TabelaAluno1.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue ov, Object t, Object t1) {
                alunoSel = (Aluno) t1;
                ConsultarPlano(alunoSel);

            }
        });
        buttonRemove.setOnMouseClicked((MouseEvent e) -> {
            ApagarAvaliacao(alunoSel);

        });

    }

    public void initTableAluno() {
        clnNome.setCellValueFactory(new PropertyValueFactory("nome"));
        clnMatricula.setCellValueFactory(new PropertyValueFactory("matricula"));
        TabelaAluno1.setItems(atualizaTabela1());

    }

    public ObservableList<Aluno> atualizaTabela1() {
        AlunoDAO dao = new AlunoDAO();
        return FXCollections.observableArrayList(dao.getList());
    }

    public void fecha() {
        PesquisaAvaliacao.getStage().close();
    }

    public void ConsultarPlano(Aluno a) {
        Avaliacao_fisicaDAO dao = new Avaliacao_fisicaDAO();
        List<Avaliacao_fisica> ava = dao.getAvaliacoes(a.getMatricula());

        //System.out.println("Altura: " + ava.get(0).getAltura());
        Collections.reverse(ava);
        lbTorax.setText(Double.toString(ava.get(0).getCircunferenciaTorax()));
        lbQuadril.setText(Double.toString(ava.get(0).getCircunferenciaQuadril()));
        lbCintura.setText(Double.toString(ava.get(0).getCircunferenciaCintura()));
        lbAbdomen.setText(Double.toString(ava.get(0).getCircunferenciaAbdomen()));
        lbCoxaD.setText(Double.toString(ava.get(0).getCircunferenciaCoxaDir()));
        lbCoxaE.setText(Double.toString(ava.get(0).getCircunferenciaCoxaEsq()));
        lbBracoD.setText(Double.toString(ava.get(0).getCircunferenciaBracoDir()));
        lbBracoE.setText(Double.toString(ava.get(0).getCircunferenciaBracoEsq()));
        lbTricipical.setText(Double.toString(ava.get(0).getDobraTricipical()));
        lbSubescapular.setText(Double.toString(ava.get(0).getDobraSubescapular()));
        lbAxMed.setText(Double.toString(ava.get(0).getDobraAxiliarMedia()));
        lbAbdominal.setText(Double.toString(ava.get(0).getDobraAbdominal()));
        lbCoxa.setText(Double.toString(ava.get(0).getDobraCoxa()));
        lbPeitoral.setText(Double.toString(ava.get(0).getDobraPeitoral()));
        lbSupa.setText(Double.toString(ava.get(0).getDobraSupraIliaca()));
        lbGordura.setText(Double.toString(ava.get(0).getTotalGordura()));
        lbObjetivo.setText(ava.get(0).getObjetivoAluno());
        lbPeso.setText(Double.toString(ava.get(0).getPeso()));
        lbCPF.setText(ava.get(0).getCpf());
        lbAltura.setText(Double.toString(ava.get(0).getAltura()));

    }

    public void ApagarAvaliacao(Aluno a) {
        if (a != null) {
            Avaliacao_fisicaDAO dao = new Avaliacao_fisicaDAO();
            dao.delete(a);
            Alert v = new Alert(AlertType.CONFIRMATION);
            v.setHeaderText("Avaliacao Removida");
            v.show();
            TabelaAluno1.setItems(atualizaTabela1());
        }
    }
}
