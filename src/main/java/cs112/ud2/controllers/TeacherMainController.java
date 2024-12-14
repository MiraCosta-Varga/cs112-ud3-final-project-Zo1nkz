package cs112.ud2.controllers;

import cs112.ud2.MainApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

//import javax.swing.*;


public class TeacherMainController {
    @FXML
    private Button AddTeacherButton;

    @FXML
    private Button ViewTeacherButton;

    @FXML
    protected void onAddTeacherButtonClick(ActionEvent actionEvent) throws IOException {
        //get the map view as a scene
        Parent teacherAddView = FXMLLoader.load(MainApplication.class.getResource("TeacherAdd-view.fxml"));
        Scene teacherAddViewScene = new Scene(teacherAddView);

        //get stage
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        //set the scene (change it) for the stage (window)
        window.setScene(teacherAddViewScene);

        //show
        window.show();
    }

    @FXML
    protected void onViewTeacherButtonClick(ActionEvent actionEvent) throws IOException {
        //get the map view as a scene

        FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("TeacherList-view.fxml"));
        Parent teacherListView = loader.load();
        Scene teacherListViewScene = new Scene(teacherListView);

        //set the teacher object to the next scene
        TeacherListController controller = loader.getController();
        controller.setTeacher();

        //get stage
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        //set the scene (change it) for the stage (window)
        window.setScene(teacherListViewScene);

        //show
        window.show();
    }
}
