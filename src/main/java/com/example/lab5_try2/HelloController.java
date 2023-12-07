package com.example.lab5_try2;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.text.DecimalFormat;

public class HelloController {
    @FXML
    private TextField A;
    @FXML
    private TextField averageT;
    @FXML
    private TextField maxX;
    @FXML
    private TextField maxY;
    @FXML
    private Button calculate;
    @FXML
    private TextField endT;
    @FXML
    private TextField countT;
    @FXML
    private TextField minX;
    @FXML
    private TextField minY;
    @FXML
    private TextField beginT;
    @FXML
    private TextField H;
    @FXML
    private TextField P;
    @FXML
    private TextField sumT;

    @FXML
    void initialize() {
        Logic logic = new Logic();
        calculate.setOnAction(event -> {
            boolean success = true;
            double begin = 0;
            double end = 0;
            double h = 0;
            double a = 0;
            double p = 0;
            try {
                begin = Double.parseDouble(beginT.getText());
                end = Double.parseDouble(endT.getText());
                h = Double.parseDouble(H.getText());
                a = Double.parseDouble(A.getText());
                p = Double.parseDouble(P.getText());
            } catch (NumberFormatException err) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Incorrect input value");
                alert.show();
                success = false;
            }
            if (success) {
                double[] xVal = logic.createFillX(begin, end, h);
                double[] y = logic.createFillY(xVal, a, p);
                DecimalFormat df = new DecimalFormat("#.###");
                countT.setText(String.valueOf(logic.count(begin, end, h)));
                maxY.setText(String.valueOf(df.format(logic.maxYNumber(y))));
                maxX.setText(String.valueOf(logic.maxXNumber(xVal)));
                minY.setText(String.valueOf(df.format(logic.minYNumber(y))));
                minX.setText(String.valueOf(logic.minXNumber(xVal)));
                sumT.setText(String.valueOf(df.format(logic.Sum(y))));
                averageT.setText(String.valueOf(df.format(logic.average(y))));
                System.out.println("Button clicked");
            }
        });
    }
}