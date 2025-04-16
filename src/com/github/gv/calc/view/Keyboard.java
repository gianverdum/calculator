package com.github.gv.calc.view;

import javax.swing.*;
import java.awt.*;

public class Keyboard extends JPanel {

    private final Color COLOR_DARK_GRAY = new Color(68,68,68);
    private final Color COLOR_LIGHT_GRAY = new Color(99,99,99);
    private final Color COLOR_ORANGE = new Color(242,163,60);

    public Keyboard() {

        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();

        setLayout(layout);

        // Row 1
        addButton("AC", COLOR_DARK_GRAY, constraints, 0, 0);
        addButton("+/-", COLOR_DARK_GRAY, constraints, 1, 0);
        addButton("%", COLOR_DARK_GRAY, constraints, 2, 0);
        addButton("/", COLOR_ORANGE, constraints, 3, 0);

        // Row 2
        addButton("7", COLOR_LIGHT_GRAY, constraints, 0, 1);
        addButton("8", COLOR_LIGHT_GRAY, constraints, 1, 1);
        addButton("9", COLOR_LIGHT_GRAY, constraints, 2, 1);
        addButton("*", COLOR_ORANGE, constraints, 3, 1);

        // Row 3
        addButton("4", COLOR_LIGHT_GRAY, constraints, 0, 2);
        addButton("5", COLOR_LIGHT_GRAY, constraints, 1, 2);
        addButton("6", COLOR_LIGHT_GRAY, constraints, 2, 2);
        addButton("-", COLOR_ORANGE, constraints, 3, 2);

        // Row 4
        addButton("1", COLOR_LIGHT_GRAY, constraints, 0, 3);
        addButton("2", COLOR_LIGHT_GRAY, constraints, 1, 3);
        addButton("3", COLOR_LIGHT_GRAY, constraints, 2, 3);
        addButton("+", COLOR_ORANGE, constraints, 3, 3);

        // Row 5
        addButton("0", COLOR_LIGHT_GRAY, constraints, 0, 4);
        addButton("0", COLOR_LIGHT_GRAY, constraints, 1, 4);
        addButton(",", COLOR_LIGHT_GRAY, constraints, 2, 4);
        addButton("=", COLOR_ORANGE, constraints, 3, 4);

    }

    private void addButton(String text, Color color, GridBagConstraints constraints, int x, int y) {

        constraints.gridx = x;
        constraints.gridy = y;
        Button button = new Button(text, color);
        add(button, constraints);
    }
}
