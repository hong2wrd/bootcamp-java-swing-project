package graphics;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JScrollBar;

public class CustomScrollBar extends JScrollBar {

    public CustomScrollBar() {
        setUI(new CustomScrollPane());
        setPreferredSize(new Dimension(8, 8));
        setForeground(new Color(48, 144, 216));
        setBackground(Color.WHITE);
    }
}