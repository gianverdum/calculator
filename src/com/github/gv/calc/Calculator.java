package com.github.gv.calc;

import javax.swing.*;

public class Calculator extends JFrame {

    public Calculator() {

        setSize(232, 322);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
