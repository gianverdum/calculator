package com.github.gv.calc.model;

import java.util.ArrayList;
import java.util.List;

public class Memory {

    private enum CommandType {
            CLEAR, NUMBER, DIV, PLUS, MINUS, TIMES, COMMA, EQUALS;
    };

    private static final Memory instance = new Memory();

    private final List<MemoryObserver> observers = new ArrayList<MemoryObserver>();

    private CommandType lastOperation = null;
    private boolean replace = false;
    private String currentText = "";
    private String bufferText = "";

    private Memory() {

    }

    public static Memory getInstance() {
        return instance;
    }

    public void addObserver(MemoryObserver observer) {
        observers.add(observer);
    }

    public String getCurrentText() {
        return currentText.isEmpty() ? "0" : currentText;
    }

    public void processCommand(String input) {

        CommandType commandType = detectCommandType(input);
        if (commandType == null) {
            return;
        } else if (commandType == CommandType.CLEAR) {
            currentText = "";
            bufferText = "";
            replace = false;
            lastOperation = null;
        } else if (commandType == CommandType.NUMBER || commandType == CommandType.COMMA) {
            currentText = replace ? input : currentText + input;
            replace = false;
        } else {
            replace = true;
            currentText = getOperationResult();
            bufferText = currentText;
            lastOperation = commandType;
        }

        observers.forEach(observer -> observer.updatedValue(getCurrentText()));
    }

    private String getOperationResult() {
        if (lastOperation == null) {
            return currentText;
        }
        double numberBuffer = Double.parseDouble(bufferText.replaceAll(",", "."));
        double currentNumber = Double.parseDouble(currentText.replaceAll(",", "."));

        double result = 0;

        if (lastOperation == CommandType.PLUS) {
            result = numberBuffer + currentNumber;
        } else if (lastOperation == CommandType.MINUS) {
            result = numberBuffer - currentNumber;
        } else if (lastOperation == CommandType.TIMES) {
            result = numberBuffer * currentNumber;
        } else if (lastOperation == CommandType.DIV) {
            result = numberBuffer / currentNumber;
        }
        String resultString = Double.toString(result).replaceAll("\\.", ",");
        boolean isInteger = resultString.endsWith(",0");
        return isInteger ? resultString.replace(",0", "") : resultString;
    }

    private CommandType detectCommandType(String text) {

        if(currentText.isEmpty() && text.equals("0")) {
            return null;
        }

        try {
            Integer.parseInt(text);
            return CommandType.NUMBER;
        } catch (NumberFormatException e) {
            if("AC".equals(text)) {
                return CommandType.CLEAR;
            } else if ("/".equals(text)) {
                return CommandType.DIV;
            } else if ("*".equals(text)) {
                return CommandType.TIMES;
            } else if ("+".equals(text)) {
                return CommandType.PLUS;
            } else if ("-".equals(text)) {
                return CommandType.MINUS;
            } else if ("=".equals(text)) {
                return CommandType.EQUALS;
            } else if (",".equals(text) && !currentText.contains(",")) {
                return CommandType.COMMA;
            }
        }

        return null;
    }
}
