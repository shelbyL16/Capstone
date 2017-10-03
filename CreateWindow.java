package signsupport;

/**
 * Created by Lucia on 2017/09/07.
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class CreateWindow extends Application implements EventHandler<ActionEvent> {

    Stage window;
    Button lessonButton;
    Scene welcome, lessonList;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;

        Label welcomeMsg = new Label("Welcome to SignSupport");

        // set dimension of window
        Pane layout1 = new Pane();
        Scene scene = new Scene(layout1, 600, 500);
        window.setScene(scene);
        window.show();


        window.setTitle("SignSupport");
        lessonButton = new Button();
        lessonButton.setText("Lessons");
        lessonButton.setLayoutX(260);
        lessonButton.setLayoutY(400);
        layout1.getChildren().add(lessonButton);

        // switch to lesson list scene when Lessons button is clicked
        lessonButton.setOnAction(e -> window.setScene(lessonList));

        Pane layout2 = new Pane();
        lessonList = new Scene(layout2, 600, 500);
        Label lessonsLable = new Label("Lessons");
        layout2.getChildren().add(lessonsLable);

    }

    @Override
    public void handle(ActionEvent event) {
        // identify which button is clicked
        if (event.getSource()==lessonButton) {

        }


    }
}
