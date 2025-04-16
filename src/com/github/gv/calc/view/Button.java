package com.github.gv.calc.view;

import javax.swing.*;
import java.awt.*;

public class Button extends JButton {

    public Button(String text, Color color) {
        setText(text);
        setFont(new Font("Courier", Font.PLAIN, 25));
        setOpaque(true);
        setBackground(color);
        setForeground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}
