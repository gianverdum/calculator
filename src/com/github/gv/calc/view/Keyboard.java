package com.github.gv.calc.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Keyboard extends JPanel implements ActionListener {

    private final Color COLOR_DARK_GRAY = new Color(68,68,68);
    private final Color COLOR_LIGHT_GRAY = new Color(99,99,99);
    private final Color COLOR_ORANGE = new Color(242,163,60);

    public Keyboard() {

        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();

        setLayout(layout);

        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.fill = GridBagConstraints.BOTH;

        // Row 1
        addButton("AC", COLOR_DARK_GRAY, constraints, 0, 0);
        addButton("\u2007\u00B1\u2007", COLOR_DARK_GRAY, constraints, 1, 0);
        addButton("\u2007%\u2007", COLOR_DARK_GRAY, constraints, 2, 0);
        addButton("\u2007/\u2007", COLOR_ORANGE, constraints, 3, 0);

        // Row 2
        addButton("\u20077\u2007", COLOR_LIGHT_GRAY, constraints, 0, 1);
        addButton("\u20078\u2007", COLOR_LIGHT_GRAY, constraints, 1, 1);
        addButton("\u20079\u2007", COLOR_LIGHT_GRAY, constraints, 2, 1);
        addButton("\u2007*\u2007", COLOR_ORANGE, constraints, 3, 1);

        // Row 3
        addButton("\u20074\u2007", COLOR_LIGHT_GRAY, constraints, 0, 2);
        addButton("\u20075\u2007", COLOR_LIGHT_GRAY, constraints, 1, 2);
        addButton("\u20076\u2007", COLOR_LIGHT_GRAY, constraints, 2, 2);
        addButton("\u2007-\u2007", COLOR_ORANGE, constraints, 3, 2);

        // Row 4
        addButton("\u20071\u2007", COLOR_LIGHT_GRAY, constraints, 0, 3);
        addButton("\u20072\u2007", COLOR_LIGHT_GRAY, constraints, 1, 3);
        addButton("\u20073\u2007", COLOR_LIGHT_GRAY, constraints, 2, 3);
        addButton("\u2007+\u2007", COLOR_ORANGE, constraints, 3, 3);

        // Row 5
        constraints.gridwidth = 2;
        addButton("0", COLOR_LIGHT_GRAY, constraints, 0, 4);
        constraints.gridwidth = 1;
        addButton("\u2007,\u2007", COLOR_LIGHT_GRAY, constraints, 2, 4);
        addButton("\u2007=\u2007", COLOR_ORANGE, constraints, 3, 4);

    }

    private void addButton(String text, Color color, GridBagConstraints constraints, int x, int y) {

        constraints.gridx = x;
        constraints.gridy = y;
        Button button = new Button(text, color);
        button.addActionListener(this);
        add(button, constraints);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() instanceof JButton) {
        JButton button = (JButton) actionEvent.getSource();
        String value = button.getText().replaceAll("[\\u2007\\s]", "");
        System.out.println(value);
        }
    }
}
