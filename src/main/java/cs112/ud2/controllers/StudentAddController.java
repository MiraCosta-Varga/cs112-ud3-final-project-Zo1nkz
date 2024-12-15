package cs112.ud2.controllers;

import cs112.ud2.MainApplication;
import cs112.ud2.models.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class StudentAddController {

    @FXML
    private TextField studentNameInput;

    @FXML
    private TextField studentGradeLevelInput;

    @FXML
    private TextField studentRaceInput;

    @FXML
    private TextField studentMathGradesInput;

    @FXML
    private TextField studentEnglishGradesInput;

    @FXML
    private ImageView stuImage1;

    @FXML
    private ImageView stuImage2;

    @FXML
    private Button AddStudentButton2;

    @FXML
    public void initialize(){
        Image studentAddImage1 = new Image(getClass().getResourceAsStream("/chibiSchoolBoy.png"));
        stuImage1.setImage(studentAddImage1);

        Image studentAddImage2 = new Image(getClass().getResourceAsStream("/cat-nerd.jpg"));
        stuImage2.setImage(studentAddImage2);
    }

    @FXML
    protected void onAddStudentButton2Click(ActionEvent actionEvent) throws IOException {
        //create the student object from the input data
        Student stu = new Student(studentNameInput.getText(), studentRaceInput.getText(), Integer.parseInt(studentGradeLevelInput.getText()), studentMathGradesInput.getText(), studentEnglishGradesInput.getText());
        System.out.println(stu);
        SharedData.addStudent(stu);

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
