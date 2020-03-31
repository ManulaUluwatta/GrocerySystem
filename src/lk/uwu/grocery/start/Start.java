package lk.uwu.grocery.start;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by Manula Uluwatta on 1/13/2020.
 */
public class Start extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root= FXMLLoader.load(getClass().getResource("/lk/uwu/grocery/ui/fxml/WellcomeScreen.fxml"));
       // primaryStage.setTitle("Hellow");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
