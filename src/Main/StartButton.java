package Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JButton;

public class StartButton extends JButton {

    public StartButton(String text) {
        super(text);
        // Set the button's background color to red
        setBackground(Color.RED);
        // Set text color (optional)
        setForeground(Color.WHITE);
        // Set the size of the button to make it bigger
        setPreferredSize(new Dimension(300, 80)); // Set width to 200px and height to 70px
        setFocusable(false); // Avoids focus problems
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Call the superclass to paint the background
        // You can add custom drawing code here if needed
    }
}
