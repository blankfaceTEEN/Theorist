package main;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class Controller {

    @FXML
    private TextField textField;

    public void outOne() {
        if (!textField.getText().equals("0"))
            textField.setText(textField.getText() + "1");
        else
            textField.setText("1");
    }

    public void outTwo() {
        if (!textField.getText().equals("0"))
            textField.setText(textField.getText() + "2");
        else
            textField.setText("2");
    }

    public void outThree() {
        if (!textField.getText().equals("0"))
            textField.setText(textField.getText() + "3");
        else
            textField.setText("3");
    }

    public void outFour() {
        if (!textField.getText().equals("0"))
            textField.setText(textField.getText() + "4");
        else
            textField.setText("4");
    }

    public void outFive() {
        if (!textField.getText().equals("0"))
            textField.setText(textField.getText() + "5");
        else
            textField.setText("5");
    }

    public void outSix() {
        if (!textField.getText().equals("0"))
            textField.setText(textField.getText() + "6");
        else
            textField.setText("6");
    }

    public void outSeven() {
        if (!textField.getText().equals("0"))
            textField.setText(textField.getText() + "7");
        else
            textField.setText("7");
    }

    public void outEight() {
        if (!textField.getText().equals("0"))
            textField.setText(textField.getText() + "8");
        else
            textField.setText("8");
    }

    public void outNine() {
        if (!textField.getText().equals("0"))
            textField.setText(textField.getText() + "9");
        else
            textField.setText("9");
    }

    public void outNull() {
        if (!textField.getText().equals("0"))
            textField.setText(textField.getText() + "0");
    }

    public void outDot() {
        if (!textField.getText().equals("0") && !textField.getText().contains("."))
            textField.setText(textField.getText() + ".");
        else if (textField.getText().equals("0"))
            textField.setText("0.");
    }

    public void outBack() {
        if (!textField.getText().equals("0"))
            textField.setText(textField.getText().substring(0, textField.getText().length() - 1));
    }

    public void outClear() {
        if (!textField.getText().equals("0"))
            textField.setText("0");
    }

    public void outPlus() {
        if (!textField.getText().equals("0"))
            textField.setText(textField.getText() + "+");
        else
            textField.setText("0+");
    }

    public void outMinus() {
        if (!textField.getText().equals("0"))
            textField.setText(textField.getText() + "-");
        else
            textField.setText("0-");
    }

    public void outMult() {
        if (!textField.getText().equals("0"))
            textField.setText(textField.getText() + "*");
        else
            textField.setText("0*");
    }

    public void outDivide() {
        if (!textField.getText().equals("0"))
            textField.setText(textField.getText() + "/");
        else
            textField.setText("0/");
    }

    public void outRemainder() {
        if (!textField.getText().equals("0"))
            textField.setText(textField.getText() + "%");
        else
            textField.setText("0%");
    }

    public void outIntDiv() {
        if (!textField.getText().equals("0"))
            textField.setText(textField.getText() + "//");
        else
            textField.setText("0//");
    }

    public void outPow() {
        if (!textField.getText().equals("0"))
            textField.setText(textField.getText() + "**");
        else
            textField.setText("0**");
    }

    public void outOpenBracket() {
        if (!textField.getText().equals("0"))
            textField.setText(textField.getText() + "(");
        else
            textField.setText("(");
    }

    public void outCloseBracket() {
        if (!textField.getText().equals("0"))
            textField.setText(textField.getText() + ")");
        else
            textField.setText(")");
    }

}
