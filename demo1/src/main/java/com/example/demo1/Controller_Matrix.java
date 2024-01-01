package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;


public class Controller_Matrix{
    @FXML
    private Button btn_back;
    @FXML
    TextField textField;
    @FXML
     private  GridPane matrix1;
    @FXML
    private  GridPane matrix2;
    @FXML
    private  GridPane matrix3;
    @FXML
    static int len;
//=======================================
    public int getLen() {
        return len;
    }

   public void setLen(int len) {
        this.len = len;
    }
//   ==================================

    int[][] ar1=new int[getLen()][getLen()];
    int[][] ar2=new int[getLen()][getLen()];
    public void action_read_matrix(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();
        makeArray1();
      /*  checker(ar1);
        checker(ar2);*/

    }
    //    ===============================zarbBtoA function
    //==========================gharine
    public void gharine(int[][] array) {
        int[][] array3 = new int[getLen()][getLen()];
        for (int i = 0; i < getLen(); i++) {
            for (int j = 0; j < getLen(); j++) {
                if (array[i][j] == 0) {
                    array3[i][j] = 1;
                } else {
                    array3[i][j] = 0;
                }
            }

        }
        result(array3);
    }
    @FXML
    private Stage currentStage;
@FXML
    private void GoToHomePage(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("firstpage.fxml"));
            Parent root = fxmlLoader.load();

            Stage newStage = new Stage();
            newStage.setTitle("home page");
            newStage.setScene(new Scene(root, 750, 700));
            currentStage = (Stage) btn_back.getScene().getWindow();

            currentStage.close(); // Close the current stage
            newStage.show(); // Show the new stage
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //    =======================================

    public void action_functions(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();
        String x=button.getText();
        switch (x){
            case"جمع":
                sum();
                break;
            case"اجتماع":
                ejtema();
                break;
            case"اشتراک":
               eshterak(); ;
                break;
            case "ضرب A در B":
                zarbAtB();
                break;
            case "ضرب B در A":
                zarbBtA();
                break;
            case "قرینه1":
                gharine(ar1);
                break;
            case "قرینه2":
                gharine(ar2);
                break;



        }


    }
    //    =======================================
    public void result(int[][] a){
       int c=0;

        for (javafx.scene.Node node : matrix3.getChildren()) {

            if (node instanceof TextField) {
                TextField textField = (TextField) node;

                try {
                    if (c==getLen()*getLen()){break;}
                    int row=c/getLen();
                    int col=c%getLen();



                    int x = a[row][col]; // Get the value from the array

                    textField.setText(String.valueOf(x));
                    c+=1;

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
    }
    //    =======================================
    public void eshterak() {
        int[][] array3 = new int[ getLen()][ getLen()];
        for (int i = 0; i <  getLen(); i++) {
            for (int j = 0; j < getLen(); j++) {
                if (ar1[i][j] == 1 && ar2[i][j] == 1) {
                    array3[i][j] = 1;
                } else {
                    array3[i][j] = 0;
                }
            }
        }
        result(array3);
    }
    //    =======================================

    public void sum(){
        int[][] Array = new int[getLen()][getLen()];
        for (int i = 0 ; i<getLen();i++){
            for (int j = 0 ; j<getLen();j++){
                Array[i][j] = ar1[i][j]+ar2[i][j];
            }
        }
       result(Array);
    }
    //    =======================================
    public void zarbAtB(){
        int ra = ar1.length;
        int ca = ar1[0].length;
        int cb = ar2[0].length;
        int[][] result1 = new int[getLen()][getLen()];
        for (int i = 0 ; i<ra;i++){
            for (int j = 0; j<cb;j++){
                for (int k = 0;k<ca;k++){
                    result1[i][j] += ar1[i][k] * ar2[k][j];
                }
            }
        }
        result(result1);
    }
    //    =======================================
    public void zarbBtA(){
        int ra = ar2.length;
        int ca = ar2[0].length;
        int cb = ar1[0].length;
        int[][] result1 = new int[getLen()][getLen()];
        for (int i = 0 ; i<ra;i++){
            for (int j = 0; j<cb;j++){
                for (int k = 0;k<ca;k++){
                    result1[i][j] += ar2[i][k] * ar1[k][j];
                }
            }
        }
        result(result1);
    }
    //    =======================================
    public void ejtema() {
        int[][] array3 = new int[getLen()][getLen()];
        for (int i = 0; i < getLen(); i++) {
            for (int j = 0; j < getLen(); j++) {
                if (ar1[i][j] == 1 | ar2[i][j] == 1) {
                    array3[i][j] = 1;
                } else {
                    array3[i][j] = 0;
                }
            }

        }

       result(array3);
    }
    //    =======================================
    public void makeArray1() {
        int[][] ar = new int[getLen()][getLen()];
        int count = 0;

        for (javafx.scene.Node node : matrix1.getChildren()) {
            if (node instanceof TextField) {
                TextField textField = (TextField) node;

                try {
                    int value = Integer.parseInt(textField.getText());
                    int row = count / getLen(); // Calculate row index based on count
                    int col = count % getLen(); // Calculate column index based on count
                    ar[row][col] = value;
                    count++;

                    // Break the loop if we've filled the 2x2 array
                    if (count > getLen()*getLen()) {
                        break;
                    }
                } catch (NumberFormatException e) {
                    // Handle the case where the text is not a valid integer
                    // You might want to display an error message or handle it accordingly
                    e.printStackTrace();
                }
            }
        }
        int[][] arr = new int[getLen()][getLen()];
        int count1 = 0;

        for (javafx.scene.Node node : matrix2.getChildren()) {
            if (node instanceof TextField) {
                TextField textField1 = (TextField) node;

                try {
                    int value1 = Integer.parseInt(textField1.getText());
                    int row1 = count1 / getLen(); // Calculate row index based on count
                    int col1 = count1 %getLen(); // Calculate column index based on count
                    arr[row1][col1] = value1;
                    count1++;

                    // Break the loop if we've filled the 2x2 array
                    if (count1 >getLen()*getLen()) {
                        break;
                    }
                } catch (NumberFormatException e) {
                    // Handle the case where the text is not a valid integer
                    // You might want to display an error message or handle it accordingly
                    e.printStackTrace();
                }
            }
        }
         this.ar1=ar;
        this.ar2=arr;
    }
    public void action_test(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();
        System.out.println( getLen());
      /*  checker(ar1);
        checker(ar2);*/

    }

    //    =======================================
    public  void checker(int  a){
        System.out.println((a))
        ;
    }


}
