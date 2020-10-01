package main;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class Controller {

    private int openBracketCount = 0;
    private int closeBracketCount = 0;
    private boolean dot = false;

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
        if (!textField.getText().equals("0")
            && (dot == false)
            && !(textField.getText().toCharArray()[textField.getText().length() - 1] == '.')
            && !(textField.getText().toCharArray()[textField.getText().length() - 1] == ' '))
        {
            textField.setText(textField.getText() + ".");
            dot = true;
        }
        else if (textField.getText().equals("0") && (dot == false)) {
            textField.setText("0.");
            dot = true;
        }
    }

    public void outBack() {
        if (!textField.getText().equals("0"))
            textField.setText(textField.getText().substring(0, textField.getText().length() - 1));
    }

    public void outClear() {
        if (!textField.getText().equals("0"))
            textField.setText("0");
        openBracketCount = 0;
        closeBracketCount = 0;
    }

    public void outPlus() {
        if (!textField.getText().equals("0"))
            textField.setText(textField.getText() + " + ");
        else
            textField.setText("0 + ");
        dot = false;
    }

    public void outMinus() {
        if (!textField.getText().equals("0"))
            textField.setText(textField.getText() + " - ");
        else
            textField.setText("0 - ");
        dot = false;
    }

    public void outMult() {
        if (!textField.getText().equals("0"))
            textField.setText(textField.getText() + " * ");
        else
            textField.setText("0 * ");
        dot = false;
    }

    public void outDivide() {
        if (!textField.getText().equals("0"))
            textField.setText(textField.getText() + " / ");
        else
            textField.setText("0 / ");
        dot = false;
    }

    public void outRemainder() {
        if (!textField.getText().equals("0"))
            textField.setText(textField.getText() + " % ");
        else
            textField.setText("0 % ");
        dot = false;
    }

    public void outIntDiv() {
        if (!textField.getText().equals("0"))
            textField.setText(textField.getText() + " // ");
        else
            textField.setText("0 // ");
        dot = false;
    }

    public void outPow() {
        if (!textField.getText().equals("0"))
            textField.setText(textField.getText() + " ** ");
        else
            textField.setText("0 ** ");
        dot = false;
    }

    public void outOpenBracket() {
        if (!textField.getText().equals("0")
            && textField.getText().toCharArray()[textField.getText().length() - 1] == ' ')
        {
            textField.setText(textField.getText() + "(");
            openBracketCount++;
            dot = false;
        }
        else if (textField.getText().equals("0")) {
            textField.setText("(");
            openBracketCount++;
            dot = false;
        }
    }

    public void outCloseBracket() {
        if (!textField.getText().equals("0") && (openBracketCount > closeBracketCount)) {
            textField.setText(textField.getText() + ")");
            closeBracketCount++;
            dot = false;
        }
    }

}
