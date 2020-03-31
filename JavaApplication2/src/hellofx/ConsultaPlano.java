package hellofx;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;




public class ConsultaPlano extends Application{

    private static Stage stage;//Uma janela
    
    
    @Override
    public void start(Stage stage) throws Exception {
        //
    Parent root = FXMLLoader.load(getClass().getResource("/View/FXMLConsu_Planos.fxml"));
        
        Scene scene = new Scene(root);//coloca fmxl na sncene
        
        stage.setScene(scene);//coloca cena na janela
        stage.setTitle("Consulta Planos");//carrega fxml
        stage.setResizable(false);
        stage.show();//abre janela
        setStage(stage);
    }

    public static void main(String[] args) {
        launch(args);
    }

  
    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage aStage) {
        ConsultaPlano.stage = aStage;
    }
}
