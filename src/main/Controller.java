package main;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Controller {
    List<Double> nums;
    List<Integer> openingBrackets;
    List<Integer> closingBrackets;
    Map<Integer, String> operators;]

    private int openBracketCount = 0;
    private int closeBracketCount = 0;
    private boolean dot = false;

    @FXML
    private TextField textField;

    List<String> in;

    public void outOne() {
        if (!textField.getText().equals("0"))
            textField.setText(textField.getText() + "1");
        else
            textField.setText("1");
    }

    public double operation(int k) {
        switch(operators.get(k)) {
            case "+": return nums.get(k) + nums.get(k + 1);
            case "-": return nums.get(k) - nums.get(k + 1);
            case "*": return nums.get(k) * nums.get(k + 1);
            case "/": return nums.get(k) / nums.get(k + 1);
            case "**": return Math.pow(nums.get(k), nums.get(k + 1));
            case "//": return Math.round(nums.get(k) / nums.get(k + 1));
            case "%": return nums.get(k) % nums.get(k + 1);
            default: return 0;
        }
    }
    public void borderW(int i) {
        nums.set(i, operation(i));
        nums.remove(i + 1);
        operators.remove(i);
    }

    public void outEquality()
    {
        in.addAll(Arrays.asList(textField.getText().split(" ")));
        if (textField.getText().toCharArray()[textField.getText().length() - 1] == '.')
            textField.setText(textField.getText() + "0");

        for(int i = 0; i < in.size(); i++) {
            if(in.get(i).contains("\\d")) {
                nums.add(Double.parseDouble(in.get(i)));
            }
            else if(in.get(i).contains("(")) {
                openingBrackets.add(i);
            }
            else if(in.get(i).contains(")")) {
                closingBrackets.add(i);
            }
            else {
                operators.put(i, in.get(i));
            }
        }
        int firBorder = 0;
        int secBorder = in.size();
        if(openingBrackets.isEmpty()) {
            for (int i : operators.keySet()) {
                if(!in.get(i).contains("[^+-]")) {
                    borderW(i);
                }
            }
        }
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
