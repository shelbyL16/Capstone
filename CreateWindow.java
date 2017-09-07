/**
 * Created by Lucia on 2017/09/07.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class CreateWindow extends Application {

    Button lessonButton;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("SignSupport");
        lessonButton = new Button();
        lessonButton.setText("Lessons");
        lessonButton.setLayoutX(100);
        lessonButton.setLayoutY(300);


        Pane layout = new Pane();
        layout.getChildren().add(lessonButton);

        Scene scene = new Scene(layout, 600, 500);
        primaryStage.setScene(scene);




        primaryStage.show();
    }
}
