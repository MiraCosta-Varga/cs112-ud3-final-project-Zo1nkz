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

public class studentMainController {
    @FXML
    private Button AddStudentButton;

    @FXML
    private Button ViewStudentButton;

    @FXML
    protected void onAddStudentButtonClick(ActionEvent actionEvent) throws IOException {
        //get the map view as a scene
        Parent studentAddView = FXMLLoader.load(MainApplication.class.getResource("StudentAdd-view.fxml"));
        Scene studentAddViewScene = new Scene(studentAddView);

        //get stage
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        //set the scene (change it) for the stage (window)
        window.setScene(studentAddViewScene);

        //show
        window.show();
    }

    @FXML
    protected void onViewStudentButtonClick(ActionEvent actionEvent) throws IOException {
        //get the map view as a scene
        //Parent studentListView = FXMLLoader.load(MainApplication.class.getResource("StudentList-view.fxml"));
        FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("StudentList-view.fxml"));
        Parent studentListView = loader.load();
        Scene studentListViewScene = new Scene(studentListView);

        //set the student object to the next scene
        StudentListController controller = loader.getController();
        controller.setStudent();

        //get stage
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        //set the scene (change it) for the stage (window)
        window.setScene(studentListViewScene);

        //show
        window.show();
    }
}
