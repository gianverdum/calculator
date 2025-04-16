package com.github.gv.calc.view;

import javax.swing.*;
import java.awt.*;

public class Calculator extends JFrame {

    public Calculator() {

        organizeLayout();

        setSize(464, 644);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void organizeLayout() {
        setLayout(new BorderLayout());

        Display display = new Display();
        display.setPreferredSize(new Dimension(464,120));
        add(display, BorderLayout.NORTH);

        Keyboard keyboard = new Keyboard();
        add(keyboard, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
