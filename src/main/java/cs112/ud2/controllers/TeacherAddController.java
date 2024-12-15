package cs112.ud2.controllers;

import cs112.ud2.MainApplication;
import cs112.ud2.models.Student;
import cs112.ud2.models.Teacher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class TeacherAddController {

    @FXML
    private TextField teacherNameInput;

    @FXML
    private TextField teacherRaceInput;

    @FXML
    private TextField teacherPrimarySubjectInput;

    @FXML
    private TextField teacherSalaryInput;

    @FXML
    private TextField teacherCoursesInput;

    @FXML
    private Button AddTeacherButton2;

    @FXML
    ImageView teachImage1;

    @FXML
    ImageView teachImage2;

    @FXML
    public void initialize(){
        Image teachAddImage1 = new Image(getClass().getResourceAsStream("/nerd-quagsire.jpg"));
        teachImage1.setImage(teachAddImage1);

        Image teachAddImage2 = new Image(getClass().getResourceAsStream("/ghibli-teacher.jpg"));
        teachImage2.setImage(teachAddImage2);
    }

    @FXML
    protected void onAddTeacherButton2Click(ActionEvent actionEvent) throws IOException {
        //create the student object from the input data
        Teacher teacher = new Teacher(teacherNameInput.getText(), teacherRaceInput.getText(), teacherPrimarySubjectInput.getText(), Integer.parseInt(teacherSalaryInput.getText()), teacherCoursesInput.getText());
        System.out.println(teacher);
        SharedData.addTeacher(teacher);


        //get the map view as a scene
        FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("TeacherList-view.fxml"));
        Parent teacherListView = loader.load();
        Scene teacherListViewScene = new Scene(teacherListView);

        //set the student object to the next scene
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
