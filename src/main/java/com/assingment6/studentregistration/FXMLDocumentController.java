package com.assingment6.studentregistration;

import com.assingment6.studentregistration.Services.StudentService;
import com.assingment6.studentregistration.models.Student;
import java.net.URL;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
@Component
public class FXMLDocumentController implements Initializable {

    @Autowired
    private StudentService studentService;

    @FXML
    private TextField txtFieldName;
    @FXML
    private TextField txtFieldMajor;
    @FXML
    private TextField txtFieldGrade;
    @FXML
    private TextField txtFieldSeachById;
    @FXML
    private TableView<Student> tableView;
    @FXML
    private TableColumn<Student, Integer> tcID;
    @FXML
    private TableColumn<Student, String> tcName;
    @FXML
    private TableColumn<Student, String> tcMajor;
    @FXML
    private TableColumn<Student, Double> tcGrade;
    @FXML
    private Button buttonShowAll;
    @FXML
    private Button buttonShowById;
    @FXML
    private Button buttonAdd;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tcID.setCellValueFactory(new PropertyValueFactory("id"));
        tcName.setCellValueFactory(new PropertyValueFactory("name"));
        tcMajor.setCellValueFactory(new PropertyValueFactory("major"));
        tcGrade.setCellValueFactory(new PropertyValueFactory("grade"));

        tableView.getSelectionModel()
                .selectedItemProperty().addListener(e -> {
                    this.showSelectedStudent();
                });

    }

    @FXML
    private void buttonShowAllHandle(ActionEvent event) {
        List<Student> students = studentService.showAll();
        tableView.getItems().setAll(students);
    }

    private void showSelectedStudent() {

        Student student = tableView.getSelectionModel().getSelectedItem();
        if (student != null) {
            txtFieldName.setText(student.getName());
            txtFieldMajor.setText(student.getMajor());
            txtFieldGrade.setText(student.getGrade() + "");
        }

    }

    @FXML
    private void buttonShowByIdHandle(ActionEvent event) {
        if (!(this.txtFieldSeachById.getText().equalsIgnoreCase("")
                || this.txtFieldSeachById.getText() == null)) {

            try {
                Student student = studentService.findById(Integer.parseInt(txtFieldSeachById.getText()));
                tableView.getItems().setAll(student);
                clearFields();

            } catch (NoSuchElementException nre) {
                Alert a = new Alert(Alert.AlertType.WARNING);
                a.setTitle("Error Retrieving");
                a.setContentText("No Student with this identity number: "
                        + this.txtFieldSeachById.getText() + ".");
                a.showAndWait();
            }

        } else {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error!");
            a.setContentText("Empty Field!");
            a.showAndWait();
        }
    }

    @FXML
    private void buttonAddHandle(ActionEvent event) {
        String sName = txtFieldName.getText();
        String sMajor = txtFieldMajor.getText();
        Double sGrade = Double.parseDouble(txtFieldGrade.getText());

        Student student = new Student(sName, sMajor, sGrade);
        this.studentService.addStudent(student);
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Add Info!");
        a.setContentText("Student Added Successfully");
        a.showAndWait();
        clearFields();

    }

    private void clearFields() {
        this.txtFieldGrade.setText("");
        this.txtFieldMajor.setText("");
        this.txtFieldName.setText("");

    }
}
