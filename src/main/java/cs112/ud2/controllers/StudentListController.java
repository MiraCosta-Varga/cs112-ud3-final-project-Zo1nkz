package cs112.ud2.controllers;

import cs112.ud2.MainApplication;
import cs112.ud2.models.Student;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentListController {

    //@FXML
    //private TextArea Student1;

    @FXML
    private VBox studentListVbox;

    @FXML
    private Button StudentListExitButton;

    //setup the list of students here
    public void setStudent(){
        //studentListVbox.getChildren().clear();
        List<Student> studentList = SharedData.getStudentList();

        for (Student student : studentList) {
            TextArea studentTextArea = new TextArea();
            studentTextArea.setEditable(false); // Make it non-editable
            studentTextArea.setWrapText(true);  // Enable text wrapping
            // Set the text for the TextArea
            studentTextArea.setText(
                    "Name: " + student.getName() + "\n" +
                            "Race: " + student.getRace() + "\n" +
                            "Grade Level: " + student.getGradeLevel() + "\n" +
                            "Math Grade: " + student.getMathAverage() + "\n" +
                            "English Grade: " + student.getEnglishAverage()
            );

            // Set a fixed height for the TextArea
            studentTextArea.setPrefHeight(100);

            // Add the TextArea to the VBox
            studentListVbox.getChildren().add(studentTextArea);
        }
    }



    @FXML
    protected void onStudentListExitButtonClick(ActionEvent actionEvent) throws IOException {
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
