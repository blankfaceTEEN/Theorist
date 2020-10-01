package main;

import javafx.fxml.FXML;

import java.awt.*;

public class Controller {

    @FXML
    private TextField textField;

    public void out() {
        textField.setText("1");
    }
}
