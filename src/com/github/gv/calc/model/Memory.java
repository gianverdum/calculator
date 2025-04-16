package com.github.gv.calc.model;

import java.util.ArrayList;
import java.util.List;

public class Memory {

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

    public void setCurrentText(String currentText) {

        if("AC".equals(currentText)) {
            this.currentText = "";
        } else {
            this.currentText = currentText;
        }
        observers.forEach(observer -> observer.updatedValue(getCurrentText()));
    }
}
