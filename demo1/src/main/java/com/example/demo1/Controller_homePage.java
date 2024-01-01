package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller_homePage {
    @FXML
    private Stage currentStage;
    @FXML
    private Button btn_2;
    @FXML
    private Button btn_3;
    @FXML
    private Button btn_4;
    Controller_Matrix obj = new Controller_Matrix();


//    ===============================





    //========================================
    public void action_btns(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();
        String x=button.getText();


        switch (x){

            case "2 در 2":
                Goto2();
                break;
            case "3 در 3":
                Goto3();
                break;
            case "4 در 4":
                Goto4();
                break;
        }
    }


    public void Goto2(){
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("dodardo.fxml"));
            Parent root = fxmlLoader.load();
            Controller_Matrix.len=2;
            Stage newStage = new Stage();
            newStage.setTitle("2X2");
            newStage.setScene(new Scene(root, 800, 700));
            currentStage = (Stage) btn_2.getScene().getWindow();

            currentStage.close(); // Close the current stage

            newStage.show(); // Show the new stage

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void Goto3(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sedarsaenew.fxml"));
            Parent root = fxmlLoader.load();
            Controller_Matrix.len=3;
            Stage newStage = new Stage();
            newStage.setTitle("3X3");
            newStage.setScene(new Scene(root, 800, 700));
            currentStage = (Stage) btn_3.getScene().getWindow();

            currentStage.close(); // Close the current stage
            newStage.show(); // Show the new stage
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Goto4(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("4dar4.fxml"));
            Parent root = fxmlLoader.load();
            Controller_Matrix.len=4;
            Stage newStage = new Stage();
            newStage.setTitle("4X4");
            newStage.setScene(new Scene(root, 800, 700));
            currentStage = (Stage) btn_4.getScene().getWindow();

            currentStage.close(); // Close the current stage
            newStage.show(); // Show the new stage
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
