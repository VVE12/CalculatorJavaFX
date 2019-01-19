package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {

    private String string = "";
    private float initValue = 0;
    private char counter;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="label"
    private Label label; // Value injected by FXMLLoader

    @FXML // fx:id="cle"
    private Button cle; // Value injected by FXMLLoader

    @FXML // fx:id="plmin"
    private Button plmin; // Value injected by FXMLLoader

    @FXML // fx:id="perc"
    private Button perc; // Value injected by FXMLLoader

    @FXML // fx:id="divis"
    private Button divis; // Value injected by FXMLLoader

    @FXML // fx:id="seven"
    private Button seven; // Value injected by FXMLLoader

    @FXML // fx:id="eight"
    private Button eight; // Value injected by FXMLLoader

    @FXML // fx:id="nine"
    private Button nine; // Value injected by FXMLLoader

    @FXML // fx:id="multi"
    private Button multi; // Value injected by FXMLLoader

    @FXML // fx:id="four"
    private Button four; // Value injected by FXMLLoader

    @FXML // fx:id="five"
    private Button five; // Value injected by FXMLLoader

    @FXML // fx:id="six"
    private Button six; // Value injected by FXMLLoader

    @FXML // fx:id="minus"
    private Button minus; // Value injected by FXMLLoader

    @FXML // fx:id="one"
    private Button one; // Value injected by FXMLLoader

    @FXML // fx:id="two"
    private Button two; // Value injected by FXMLLoader

    @FXML // fx:id="three"
    private Button three; // Value injected by FXMLLoader

    @FXML // fx:id="plus"
    private Button plus; // Value injected by FXMLLoader

    @FXML // fx:id="zero"
    private Button zero; // Value injected by FXMLLoader

    @FXML // fx:id="point"
    private Button point; // Value injected by FXMLLoader

    @FXML // fx:id="equ"
    private Button equ; // Value injected by FXMLLoader

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        zero.setOnAction(event -> {
            putTheValue(0);
        });
        one.setOnAction(event -> {
            putTheValue(1);
        });
        two.setOnAction(event -> {
            putTheValue(2);
        });
        three.setOnAction(event -> {
            putTheValue(3);
        });
        four.setOnAction(event -> {
            putTheValue(4);
        });
        five.setOnAction(event -> {
            putTheValue(5);
        });
        six.setOnAction(event -> {
            putTheValue(6);
        });
        seven.setOnAction(event -> {
            putTheValue(7);
        });
        eight.setOnAction(event -> {
            putTheValue(8);
        });
        nine.setOnAction(event -> {
            putTheValue(9);
        });
        plus.setOnAction(event -> {
            countTheValue('+');
        });
        minus.setOnAction(event -> {
            countTheValue('-');
        });
        multi.setOnAction(event -> {
            countTheValue('*');
        });
        divis.setOnAction(event -> {
            countTheValue('/');
        });
        equ.setOnAction(event -> {
            if (this.counter == '+' || this.counter == '-' || this.counter == '*' || this.counter != '/')
                matchTheValue();
        });
        point.setOnAction(event -> {
            if (!this.string.contains(".")) {
                this.string += ".";
                label.setText(string);
            }
        });
        perc.setOnAction(event -> {
            if (this.string != "") {
                float newString = Float.parseFloat(this.string) * 0.1f;
                this.string = Float.toString(newString);
                label.setText(string);
            }
        });
        plmin.setOnAction(event -> {
            if (this.string != "") {
                float newString = Float.parseFloat(this.string) * -1;
                this.string = Float.toString(newString);
                label.setText(string);
            }
        });
        cle.setOnAction(event -> {
            label.setText("0");
            this.string = "";
            this.initValue = 0;
            this.counter ='A';
        });
    }

    private void matchTheValue() {
        float outputValue = 0;
        switch (this.counter) {
            case '+': outputValue = this.initValue + Float.parseFloat(this.string); break;
            case '-': outputValue = this.initValue - Float.parseFloat(this.string); break;
            case '*': outputValue = this.initValue * Float.parseFloat(this.string); break;
            case '/': if (Integer.parseInt(this.string) != 0) outputValue = this.initValue / Float.parseFloat(this.string); else outputValue = 0; break;
        }
        label.setText(Float.toString(outputValue));
        this.string = "";
        this.counter = 'A';
        this.initValue = 0;
    }

    private void countTheValue(char counter) {
        if (this.counter != '+' && this.counter != '-' && this.counter != '*' && this.counter != '/') {
            this.initValue = Float.parseFloat(string);
            label.setText(String.valueOf(counter));
            this.string = "";
            this.counter = counter;
        }
    }

    private void putTheValue(int value) {
        this.string += Integer.toString(value);
        label.setText(string);
    }
}
