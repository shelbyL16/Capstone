package signsupport;

import com.jfoenix.controls.JFXButton;
import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

// main controller class

public class Controller {

    private ArrayList<JButton> buttons = new ArrayList<>();
    private ArrayList<Screen> screenArr = new ArrayList<>();

    // for when 'Lesson' button is clicked on HomePage - transition to LessonList
    @FXML
    public void lessonButtonClicked(ActionEvent event) throws IOException {

        Parent layout = FXMLLoader.load(getClass().getResource("LessonList.fxml"));
        Scene lessonList = new Scene(layout);
        Stage lessonStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        lessonStage.setScene(lessonList);
        lessonStage.show();
    }

    // for when 'Back' button is clicked on LessonList page - transition back to HomePage
    @FXML
    public void backToHomeClicked(ActionEvent event) throws IOException {

        //System.out.println("Button clicked");

        Parent layout = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        Scene home = new Scene(layout);
        Stage homeStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        homeStage.setScene(home);
        homeStage.show();
    }

    /*private void addButton() {

        StackPane pane = new StackPane();

        for (int i=0; i<10; i++) {
            buttons.add(new JButton("Button " + i));

        }

    }*/

    // for when 'Lesson'  is clicked on LessonList - transition to tasks
    @FXML
    public void taskButtonClicked(ActionEvent event) throws IOException {

        Parent layout = FXMLLoader.load(getClass().getResource("TaskList.fxml"));


        Scene lessonList = new Scene(layout);
        Stage lessonStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        lessonStage.setScene(lessonList);
        lessonStage.show();

    }

    public void addButtons(ActionEvent event) throws IOException {
        JFXButton btn = (JFXButton) event.getSource();
        System.out.println(btn.getText());

        VBox layout = new VBox();


        switch(btn.getText())
        {
            case "Lesson 1":
                for (int i=0; i<screenArr.size(); i++) {
                    JFXButton b = new JFXButton(String.valueOf(i));
                    layout.getChildren().add(b);
                }

                Parse p = new Parse();
                screenArr = p.parse();

                break;
            case "Lesson 2":FXMLDocumentController.rootP.setStyle("-fx-background-color:#0000FF");
                break;
            case "Lesson 3":FXMLDocumentController.rootP.setStyle("-fx-background-color:#FF0000");
                break;
        }
        Scene home = new Scene(layout);
        Stage homeStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        homeStage.setScene(home);
        homeStage.show();
    }

    /*@FXML
    public void populateListView() throws IOException {

        ObservableList<String> taskNames = FXCollections.observableArrayList();

        Parse p = new Parse();
        screenArr = p.parse();

        //System.out.println(screenArr.get(0).getVidCaption());

        for (int i=0; i<screenArr.size(); i++) {
            taskNames.add(screenArr.get(i).getVidCaption());
        }


        listView.setItems(taskNames);


    }*/

}
