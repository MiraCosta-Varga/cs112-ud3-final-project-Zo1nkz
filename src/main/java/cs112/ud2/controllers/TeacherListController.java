package cs112.ud2.controllers;

import cs112.ud2.MainApplication;
import cs112.ud2.models.Student;
import cs112.ud2.models.Teacher;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class TeacherListController {

    @FXML
    private VBox teacherListVbox;

    @FXML
    private Button TeacherListExitButton;

    public void setTeacher(){
        //studentListVbox.getChildren().clear();
        List<Teacher> teacherList = SharedData.getTeacherList();

        for (Teacher teacher : teacherList) {
            TextArea teacherTextArea = new TextArea();
            teacherTextArea.setEditable(false); // Make it non-editable
            teacherTextArea.setWrapText(true);  // Enable text wrapping
            // Set the text for the TextArea
            teacherTextArea.setText(
                    "Name: " + teacher.getName() + "\n" +
                            "Race: " + teacher.getRace() + "\n" +
                            "Primary Subject: " + teacher.getSubject() + "\n" +
                            "Salary: " + teacher.getSalary() + "\n" +
                            "Courses Taught: " + teacher.getCourses()
            );

            // Set a fixed height for the TextArea
            teacherTextArea.setPrefHeight(100);

            // Add the TextArea to the VBox
            teacherListVbox.getChildren().add(teacherTextArea);
        }
    }

    @FXML
    protected void onTeacherListExitButtonClick(ActionEvent actionEvent) throws IOException {
        //get the map view as a scene
        Parent mainView = FXMLLoader.load(MainApplication.class.getResource("main-view.fxml"));
        Scene mainViewScene = new Scene(mainView);

        //get stage
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        //set the scene (change it) for the stage (window)
        window.setScene(mainViewScene);

        //show
        window.show();
    }
}
