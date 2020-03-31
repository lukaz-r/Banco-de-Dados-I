package hellofx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Contrata1 extends Application {
    
    private static Stage stage;//Uma janela
    
    
    @Override
    public void start(Stage stage) throws Exception {
        //
    Parent root = FXMLLoader.load(getClass().getResource("/View/FXMLContrata.fxml"));
        
        Scene scene = new Scene(root);//coloca fmxl na sncene
        
        stage.setScene(scene);//coloca cena na janela
        stage.setTitle("Contrata Pacote");//carrega fxml
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
        Contrata1.stage = aStage;
    }
    
}
