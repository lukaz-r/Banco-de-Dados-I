/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hellofx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author CUZIM
 */
public class AtualizaAvaliacao extends Application {
    
    private static Stage stage;//Uma janela
    
    
    @Override
    public void start(Stage stage) throws Exception {
        //
    Parent root = FXMLLoader.load(getClass().getResource("/View/FXMLAtul_avaliacao.fxml"));
        
        Scene scene = new Scene(root);//coloca fmxl na sncene
        
        stage.setScene(scene);//coloca cena na janela
        stage.setTitle("Login");//carrega fxml
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
        AtualizaAvaliacao.stage = aStage;
    }
}
