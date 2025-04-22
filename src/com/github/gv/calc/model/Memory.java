package com.github.gv.calc.model;

import java.util.ArrayList;
import java.util.List;

public class Memory {

    private enum CommandType {
            CLEAR, NUMBER, DIV, MUL, PLUS, MINUS, TIMES, COMMA, EQUALS;
    };

    private static final Memory instance = new Memory();

    private final List<MemoryObserver> observers = new ArrayList<MemoryObserver>();

    private String currentText = "";

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
        System.out.println("CommandType: " + commandType);
        switch (commandType) {
            case CLEAR:
                currentText = "";
                break;
            case NUMBER:
            case COMMA:
            case DIV:
            case MUL:
            case PLUS:
            case MINUS:
            case EQUALS:
                currentText += input;
                break;
            case null, default:
                break;
        }
        observers.forEach(observer -> observer.updatedValue(getCurrentText()));
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
                return CommandType.MUL;
            } else if ("+".equals(text)) {
                return CommandType.PLUS;
            } else if ("-".equals(text)) {
                return CommandType.MINUS;
            } else if ("=".equals(text)) {
                return CommandType.EQUALS;
            } else if (",".equals(text)) {
                return CommandType.COMMA;
            }
        }

        return null;
    }
}
