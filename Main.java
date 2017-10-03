package signsupport;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    Stage window;
    public static Boolean isSplashLoaded = false;


    @Override
    public void start(Stage primaryStage) throws Exception {

        window = primaryStage;

        Parent layout = FXMLLoader.load(getClass().getResource("HomePage.fxml"));

        window.setTitle("SignSupport");
        window.setScene(new Scene(layout));
        window.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
