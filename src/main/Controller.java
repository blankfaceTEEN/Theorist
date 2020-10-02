package main;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Controller {
    List<Double> nums = new LinkedList<>();
    List<String> operators = new LinkedList<>();
    Map<Integer, Integer> brackets = new HashMap<>();
    List<String> in = new LinkedList<>();

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
    public void borderL(int i) {
        nums.set(i, operation(i));
        nums.remove(i + 1);
        operators.remove(i);
    }
    public void borderW(int i) {
        nums.set(i + openBracketCount, operation(i + openBracketCount));
        nums.remove(i + openBracketCount + 1);
        operators.remove(i);
    }

    public void outEquality()
    {
        in = Arrays.asList(textField.getText().split(" "));
        if (textField.getText().toCharArray()[textField.getText().length() - 1] == '.')
            textField.setText(textField.getText() + "0");

        for(int i = 0; i < in.size(); i++) {
            if(in.get(i).matches("[\\d]")) {
                nums.add(Double.parseDouble(in.get(i)));
            }
            else if(in.get(i).matches("\\(")) {
                operators.add(Integer.toString(i));
            }
            else if(in.get(i).matches("^\\)")) {
                operators.add(in.get(i));
            }
        }
        int t = 0;

        for (int i = in.size() - 1; i > 0; i--) {
            if (in.get(i).equals("(")) {
                for (int j = i; j < in.size(); j++) {
                    if (!in.get(i).matches("[\\d]")) {
                        t += 1;
                        operators.set(i, Integer.toString(t));
                    } else if (in.get(i).contains(")")) {
                        break;
                    }
                }
            }
        }
        while(!operators.isEmpty()) {
            if (!operators.contains("(")) {
                //bracketless block
                if (!operators.contains("[^+-]")) {
                    for (int i = 0; i < operators.size(); i++) {
                        borderL(0);
                    }
                } else if (operators.contains("[^+-]")) {
                    for (int i = 0; i < operators.size(); i++) {
                        if (operators.get(i).contains("[^+-]")) {
                            borderL(i);
                            break;
                        }
                    }
                }
            }
            else {
                //brackets block
                for(int j = 0; j < openBracketCount; j++) {
                    if (!operators.contains("[^+-]")) {
                        for (int i = 0; i < operators.size(); i++) {
                            borderW(0);
                        }
                    } else if (operators.contains("[^+-]")) {
                        for (int i = 0; i < operators.size(); i++) {
                            if (operators.get(i).contains("[^+-]")) {
                                borderW(i);
                                break;
                            }
                        }
                    }
                }
            }
        }
        textField.setText(nums.get(0).toString());
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
