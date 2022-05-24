package com.assingment6.studentregistration;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentregistrationApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader
                = new FXMLLoader(getClass().getResource("/fxml/FXMLDocument.fxml"));
        loader.setControllerFactory(
                SpringApplication.run(StudentregistrationApplication.class)::getBean);
        Parent root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setTitle("Assignment 6 Spring Boot");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

}
