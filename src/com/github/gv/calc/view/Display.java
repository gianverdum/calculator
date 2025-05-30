package com.github.gv.calc.view;

import com.github.gv.calc.model.Memory;
import com.github.gv.calc.model.MemoryObserver;

import javax.swing.*;
import java.awt.*;

public class Display extends JPanel implements MemoryObserver {

    private final JLabel label;

    public Display() {
        Memory.getInstance().addObserver(this);

        setBackground(new Color(46,49,50));
        label = new JLabel(Memory.getInstance().getCurrentText());
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Courier", Font.PLAIN, 25));

        setLayout(new FlowLayout(FlowLayout.RIGHT,20,75));
        add(label);

    }

    @Override
    public void updatedValue(String newValue) {
        label.setText(newValue);
    }
}
