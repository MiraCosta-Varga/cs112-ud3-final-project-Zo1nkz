package cs112.ud2.controllers;

import cs112.ud2.MainApplication;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

//import javax.swing.*;
import java.io.IOException;

public class MainController {
    @FXML
    private ImageView mainImage;

    @FXML
    private Label welcomeText;

    @FXML
    private Button Button1;

    @FXML
    private Button Button2;

    @FXML
    private Button QuitButton;

    @FXML
    public void initialize(){
        Image myImage = new Image(getClass().getResourceAsStream("/cover.gif"));
        mainImage.setImage(myImage);
    }

    @FXML
    protected void onTeacherButtonClick(ActionEvent actionEvent) throws IOException {
        welcomeText.setText("teacher");
        //get the map view as a scene
        Parent teacherMainView = FXMLLoader.load(MainApplication.class.getResource("TeacherMain-view.fxml"));
        Scene teacherMainViewScene = new Scene(teacherMainView);

        //get stage
        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();

        //set the scene (change it) for the stage (window)
        window.setScene(teacherMainViewScene);

        //show
        window.show();

    }

    @FXML
    protected void onStudentButtonClick(ActionEvent actionEvent) throws IOException  {
        welcomeText.setText("student");
        //get the map view as a scene
        Parent studentMainView = FXMLLoader.load(MainApplication.class.getResource("StudentMain-view.fxml"));
        Scene studentMainViewScene = new Scene(studentMainView);

        //get stage
        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();

        //set the scene (change it) for the stage (window)
        window.setScene(studentMainViewScene);

        //show
        window.show();
    }

    @FXML
    protected void onQuitButtonClick(){
        Platform.exit();
    }
}