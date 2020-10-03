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
    public double operationW(int k) {
        switch(operators.get(k - openBracketCount)) {
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
        nums.set(i + openBracketCount, operationW(i + openBracketCount));
        nums.remove(i + openBracketCount + 1);
        operators.remove(i);
    }

    public void outEquality()
    {
        // Ввод
        in = Arrays.asList(textField.getText().split(" "));
        if (textField.getText().toCharArray()[textField.getText().length() - 1] == '.')
            textField.setText(textField.getText() + "0");
        if (openBracketCount != closeBracketCount) {
            textField.setText(textField.getText() + ")");
        }
        // Заполнение списков
        for(int i = 0; i < in.size(); i++) {
            if(in.get(i).matches("[\\d]")) {
                nums.add(Double.parseDouble(in.get(i)));
            }
            else if(in.get(i).contains("(")) {
                operators.add(Integer.toString(i));
            }
            else if(!in.get(i).matches("[.).]")) {
                operators.add(in.get(i));
            }
        }
        for(String el : operators) {
            System.out.println("pervaya " + el);
        }
        // Определение количества операций внутри каждых скобок
        int t = 0;
        for (int i = in.size() - 1; i >= 0; i--) {
            if (in.get(i).equals("(")) {
                for (int j = i; j < in.size(); j++) {
                    if (!in.get(j).matches("\\d+") && !in.get(j).contains(")") && !in.get(j).contains("(")) {
                        t += 1;
                        System.out.println(in.get(j));
                        System.out.println(in.get(i));
                        operators.set(i - t, Integer.toString(t));
                    } else if (in.get(j).contains(")")) {
                        t = 0;
                        break;
                    }
                }
            }
        }
        // Выполнение операций
        for(String el : operators) {
            System.out.println("vtoraya " + el);
        }
        while(!operators.isEmpty()) {
            if (!operators.contains("1") && !operators.contains("2") && !operators.contains("3")
                    && !operators.contains("4") && !operators.contains("5") && !operators.contains("6")
                    && !operators.contains("7") && !operators.contains("8") && !operators.contains("9")) {
                //без скобок
                if (!operators.contains("*") && !operators.contains("/") && !operators.contains("//")
                        && !operators.contains("%") && !operators.contains("**")) {
                    for (int i = 0; i < operators.size(); i++) {
                        borderL(0);
                    }
                }
                else {
                    for (int i = 0; i < operators.size(); i++) {
                        if (!operators.get(i).matches("[-+]")) {
                            borderL(i);
                            break;
                        }
                    }
                }
            }
            else {

                //со скобками
                for(int j = 0; j < openBracketCount; j++) {
                    if (!operators.contains("*") && !operators.contains("/") && !operators.contains("//")
                            && !operators.contains("%") && !operators.contains("**")) {
                        for (int i = operators.size() - 1; i >= 0; i--) {
                            if (operators.get(i).matches("\\d+")) {
                                for(int l = i + 1; l < i + Integer.parseInt(operators.get(i)); l++) {
                                    borderW(l);
                                    operators.set(i, Integer.toString(Integer.parseInt(operators.get(i)) - 1));
                                }
                                openBracketCount -= 1;
                                operators.remove(i);
                            }
                        }
                    }
                    else {
                        for (int i = operators.size() - 1; i >= 0; i--) {
                            if (operators.get(i).matches("\\d+")) {
                                for(int l = i + 1; l < i + Integer.parseInt(operators.get(i)); l++) {
                                    if (!operators.get(l).matches("[-+]")) {
                                        borderW(i);
                                        operators.set(i, Integer.toString(Integer.parseInt(operators.get(i)) - 1));
                                        break;
                                    }
                                }
                                openBracketCount -= 1;
                                operators.remove(i);
                            }
                        }

                    }
                }
            }
        }
        // Вывод
        textField.setText(nums.get(0).toString());
    }

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
            textField.setText(textField.getText() + "( ");
            openBracketCount++;
            dot = false;
        }
        else if (textField.getText().equals("0")) {
            textField.setText("( ");
            openBracketCount++;
            dot = false;
        }
    }

    public void outCloseBracket() {
        if (!textField.getText().equals("0") && (openBracketCount > closeBracketCount)) {
            textField.setText(textField.getText() + " )");
            closeBracketCount++;
            dot = false;
        }
    }

}
